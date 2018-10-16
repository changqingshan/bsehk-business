package com.bsehk.business.dao.mapper;

import com.bsehk.business.domain.RefundRuleInfo;

public interface RefundRuleInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(RefundRuleInfo record);

    int insertSelective(RefundRuleInfo record);

    RefundRuleInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RefundRuleInfo record);

    int updateByPrimaryKey(RefundRuleInfo record);
}