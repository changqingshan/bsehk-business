package com.bsehk.business.dao.mapper;

import com.bsehk.business.domain.CardOperation;

public interface CardOperationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CardOperation record);

    int insertSelective(CardOperation record);

    CardOperation selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CardOperation record);

    int updateByPrimaryKey(CardOperation record);
}