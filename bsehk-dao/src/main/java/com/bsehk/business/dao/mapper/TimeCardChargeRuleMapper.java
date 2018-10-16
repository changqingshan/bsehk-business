package com.bsehk.business.dao.mapper;

import com.bsehk.business.domain.TimeCardChargeRule;

public interface TimeCardChargeRuleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TimeCardChargeRule record);

    int insertSelective(TimeCardChargeRule record);

    TimeCardChargeRule selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TimeCardChargeRule record);

    int updateByPrimaryKey(TimeCardChargeRule record);
}