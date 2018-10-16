package com.bsehk.business.dao.mapper;

import com.bsehk.business.domain.ValueCardChargeRule;

public interface ValueCardChargeRuleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ValueCardChargeRule record);

    int insertSelective(ValueCardChargeRule record);

    ValueCardChargeRule selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ValueCardChargeRule record);

    int updateByPrimaryKey(ValueCardChargeRule record);
}