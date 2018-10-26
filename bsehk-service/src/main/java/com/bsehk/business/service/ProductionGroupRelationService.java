package com.bsehk.business.service;

import com.bsehk.business.domain.ProductionGroupRelation;

import java.util.List;

/**
 * Created by 24398 on 2018/10/26.
 */
public interface ProductionGroupRelationService {
    Long numberProduction(Long venueProductionGroupId, Boolean isDelete);

    List<ProductionGroupRelation> pageProductionGroupRelation(Long venueProductionGroupId, Integer pageNum, Integer pageSize, Boolean isDelete);
}
