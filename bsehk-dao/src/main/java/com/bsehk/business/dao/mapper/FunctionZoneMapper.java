package com.bsehk.business.dao.mapper;

import com.bsehk.business.domain.FunctionZone;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FunctionZoneMapper {
    int deleteByPrimaryKey(Long id);

    int insert(FunctionZone record);

    int insertSelective(FunctionZone record);

    FunctionZone selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FunctionZone record);

    int updateByPrimaryKey(FunctionZone record);

    List<FunctionZone> listByIds(@Param("list") List<Long> functionZoneIds,@Param("isDelete") Boolean isDelete);
}