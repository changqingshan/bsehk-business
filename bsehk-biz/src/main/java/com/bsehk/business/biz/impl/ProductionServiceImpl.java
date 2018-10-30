package com.bsehk.business.biz.impl;

import com.bsehk.business.dao.mapper.ProductionMapper;
import com.bsehk.business.domain.Production;
import com.bsehk.business.service.ProductionService;
import com.bsehk.business.service.vo.ProductionVO;
import com.bsehk.common.util.PageInfo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by 24398 on 2018/10/25.
 */
@Slf4j
@Service
public class ProductionServiceImpl implements ProductionService {

    @Resource
    private ProductionMapper productionMapper;


    @Override
    public List<ProductionVO> listProductionVO(Long venueId,Boolean onShelf,Boolean isDelete) {
        Long number = this.productionMapper.numberByVenueId(venueId,false);
        List<Production> productions = this.productionMapper.listByVenueId(venueId,onShelf,isDelete);
        List<ProductionVO> productionVOS = productions.parallelStream().map(production -> ProductionVO.builder()
                                                         .productionId(production.getId())
                                                         .productionName(production.getProductionName())
                                                         .productionPrice(""+production.getProductionPrice())
                                                         .url(production.getProductionUrl())
                                                         .build())
                                                    .collect(Collectors.toList());


        return productionVOS;
    }


    @Override
    public List<Production> listByIds(List<Long> productionIds, Boolean isDelete) {
        if(productionIds == null || productionIds.isEmpty()){
            return Collections.emptyList();
        }
        List<Production> productions = this.productionMapper.listByIds(productionIds,isDelete);
        return productions;
    }
}
