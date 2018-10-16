package com.bsehk.business.dao.mapper;

import com.bsehk.business.domain.CardDiscountInfo;

public interface CardDiscountInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CardDiscountInfo record);

    int insertSelective(CardDiscountInfo record);

    CardDiscountInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CardDiscountInfo record);

    int updateByPrimaryKey(CardDiscountInfo record);
}