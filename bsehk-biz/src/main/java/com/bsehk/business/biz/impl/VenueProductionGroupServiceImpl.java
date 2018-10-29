package com.bsehk.business.biz.impl;

import com.bsehk.business.dao.mapper.VenueProductionGroupMapper;
import com.bsehk.business.domain.Production;
import com.bsehk.business.domain.ProductionGroupRelation;
import com.bsehk.business.domain.VenueProductionGroup;
import com.bsehk.business.service.ProductionGroupRelationService;
import com.bsehk.business.service.ProductionService;
import com.bsehk.business.service.VenueProductionGroupService;
import com.bsehk.business.service.vo.ProductionVO;
import com.bsehk.common.exception.BizException;
import com.bsehk.common.util.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by 24398 on 2018/10/26.
 */

@Slf4j
@Service
public class VenueProductionGroupServiceImpl implements VenueProductionGroupService {

    @Resource
    private ProductionService productionService;

    @Resource
    private VenueProductionGroupMapper venueProductionGroupMapper;
    @Resource
    private ProductionGroupRelationService productionGroupRelationService;

    @Override
    public PageInfo<List<ProductionVO>> pageProduction(Long venueId, Long venueProductionGroupId, Integer pageNum, Integer pageSize) {
        if(venueProductionGroupId == null){
            // 首次进入列表页面
           VenueProductionGroup defaultVenueProductionGroup = this.venueProductionGroupMapper.getDefault(venueId,true,false);
           if(defaultVenueProductionGroup == null){
               throw new BizException("没有查询到场馆默认的产品分组");
           }
           venueProductionGroupId = defaultVenueProductionGroup.getId();
        }

        // 分页查询分组产品
        Long total = this.productionGroupRelationService.numberProduction(venueProductionGroupId,false);

        List<ProductionGroupRelation> productionGroupRelations = this.productionGroupRelationService.pageProductionGroupRelation(venueProductionGroupId,pageNum,pageSize,false);
        if(productionGroupRelations == null || productionGroupRelations.isEmpty()){
            return new PageInfo<>();
        }

        // 查询产品
        List<Long> productionIds = productionGroupRelations.parallelStream().map(ProductionGroupRelation::getProductionId).collect(Collectors.toList());
        List<Production> productions = this.productionService.listByIds(productionIds,false);

        // 转换
        List<ProductionVO> productionVOS = productions.parallelStream().map(production -> ProductionVO.builder()
                                                         .productionId(production.getId())
                                                         .productionName(production.getProductionName())
                                                         .url(production.getProductionUrl())
                                                         .productionPrice(""+production.getProductionPrice())
                                                         .build() )
                                                     .collect(Collectors.toList());


        PageInfo<List<ProductionVO>> pageInfo = new PageInfo(pageNum,pageSize,total,productionVOS);

        return pageInfo;
    }


    @Override
    public Map<String, Object> defaultGroupProduction(Long venueId,Integer pageNum,Integer pageSize) {
        // 查询产品分组
         List<VenueProductionGroup> venueProductionGroups = this.venueProductionGroupMapper.listByVenueId(venueId,false);
         if(venueProductionGroups == null || venueProductionGroups.isEmpty()){
             return new HashMap();
         }
         // 查询默认分组产品
        PageInfo<List<ProductionVO>> pageInfo = this.pageProduction(venueId,null,pageNum,pageSize);

        Map<String,Object> map = new HashMap<>();
        map.put("venueProductionGroups",venueProductionGroups);
        map.put("productionPageInfo",pageInfo);

        return map;
    }
}
