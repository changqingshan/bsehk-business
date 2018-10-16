package com.bsehk.business.dao.mapper;

import com.bsehk.business.domain.SportCategory;

public interface SportCategoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SportCategory record);

    int insertSelective(SportCategory record);

    SportCategory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SportCategory record);

    int updateByPrimaryKey(SportCategory record);
}