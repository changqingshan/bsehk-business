package com.bsehk.business.biz.impl;

import com.bsehk.business.dao.mapper.ProductionGroupRelationMapper;
import com.bsehk.business.domain.ProductionGroupRelation;
import com.bsehk.business.service.ProductionGroupRelationService;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 24398 on 2018/10/26.
 */

@Service
@Slf4j
public class ProductionGroupRelationServiceImpl implements ProductionGroupRelationService {

    @Resource
    private ProductionGroupRelationMapper productionGroupRelationMapper;

    @Override
    public Long numberProduction( Long venueProductionGroupId, Boolean isDelete) {
         Long number = this.productionGroupRelationMapper.numberProduction(venueProductionGroupId,isDelete);
        return number;
    }


    @Override
    public List<ProductionGroupRelation> pageProductionGroupRelation( Long venueProductionGroupId, Integer pageNum, Integer pageSize, Boolean isDelete) {
       PageHelper.startPage(pageNum,pageSize);
       List<ProductionGroupRelation> productionGroupRelations = this.productionGroupRelationMapper.listProductionRelation(venueProductionGroupId,isDelete);
        return productionGroupRelations;
    }
}
