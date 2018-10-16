package com.bsehk.business.dao.mapper;

import com.bsehk.business.domain.RefundRule;

public interface RefundRuleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(RefundRule record);

    int insertSelective(RefundRule record);

    RefundRule selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RefundRule record);

    int updateByPrimaryKey(RefundRule record);
}