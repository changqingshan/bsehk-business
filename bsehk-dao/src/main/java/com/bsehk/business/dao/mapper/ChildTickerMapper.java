package com.bsehk.business.dao.mapper;

import com.bsehk.business.domain.ChildTicker;

public interface ChildTickerMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ChildTicker record);

    int insertSelective(ChildTicker record);

    ChildTicker selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ChildTicker record);

    int updateByPrimaryKey(ChildTicker record);
}