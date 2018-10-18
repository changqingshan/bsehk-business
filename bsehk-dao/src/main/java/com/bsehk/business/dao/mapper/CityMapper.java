package com.bsehk.business.dao.mapper;

import com.bsehk.business.domain.City;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CityMapper {
    int deleteByPrimaryKey(Long id);

    int insert(City record);

    int insertSelective(City record);

    City selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(City record);

    int updateByPrimaryKey(City record);

    List<City> listAll(byte isDeleted);

    List<City> listByIds(@Param("list") List<Long> cityIds,@Param("isDeleted") Boolean isDeleted);
}