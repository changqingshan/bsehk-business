package com.bsehk.business.dao.mapper;

import com.bsehk.business.domain.SportCategory;

import java.util.List;

public interface SportCategoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SportCategory record);

    int insertSelective(SportCategory record);

    SportCategory selectByPrimaryKey(Long id);

    List<SportCategory> selectAllSport();

    int updateByPrimaryKeySelective(SportCategory record);

    int updateByPrimaryKey(SportCategory record);
}