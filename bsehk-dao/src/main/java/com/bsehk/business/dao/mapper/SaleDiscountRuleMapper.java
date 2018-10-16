package com.bsehk.business.dao.mapper;

import com.bsehk.business.domain.SaleDiscountRule;

public interface SaleDiscountRuleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SaleDiscountRule record);

    int insertSelective(SaleDiscountRule record);

    SaleDiscountRule selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SaleDiscountRule record);

    int updateByPrimaryKey(SaleDiscountRule record);
}