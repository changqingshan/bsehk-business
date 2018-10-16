package com.bsehk.business.dao.mapper;

import com.bsehk.business.domain.Card;

public interface CardMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Card record);

    int insertSelective(Card record);

    Card selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Card record);

    int updateByPrimaryKey(Card record);
}