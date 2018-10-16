package com.bsehk.business.dao.mapper;

import com.bsehk.business.domain.CardUsage;

public interface CardUsageMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CardUsage record);

    int insertSelective(CardUsage record);

    CardUsage selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CardUsage record);

    int updateByPrimaryKey(CardUsage record);
}