package com.bsehk.business.dao.mapper;

import com.bsehk.business.domain.SaleWeek;

public interface SaleWeekMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SaleWeek record);

    int insertSelective(SaleWeek record);

    SaleWeek selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SaleWeek record);

    int updateByPrimaryKey(SaleWeek record);
}