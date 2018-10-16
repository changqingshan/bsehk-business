package com.bsehk.business.dao.mapper;

import com.bsehk.business.domain.FunctionZone;

public interface FunctionZoneMapper {
    int deleteByPrimaryKey(Long id);

    int insert(FunctionZone record);

    int insertSelective(FunctionZone record);

    FunctionZone selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FunctionZone record);

    int updateByPrimaryKey(FunctionZone record);
}