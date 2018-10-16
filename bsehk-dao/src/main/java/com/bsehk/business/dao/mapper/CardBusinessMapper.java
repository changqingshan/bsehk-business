package com.bsehk.business.dao.mapper;

import com.bsehk.business.domain.CardBusiness;

public interface CardBusinessMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CardBusiness record);

    int insertSelective(CardBusiness record);

    CardBusiness selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CardBusiness record);

    int updateByPrimaryKey(CardBusiness record);
}