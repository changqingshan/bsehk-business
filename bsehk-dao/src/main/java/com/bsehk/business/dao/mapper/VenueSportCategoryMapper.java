package com.bsehk.business.dao.mapper;

import com.bsehk.business.domain.VenueSportCategory;

public interface VenueSportCategoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(VenueSportCategory record);

    int insertSelective(VenueSportCategory record);

    VenueSportCategory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(VenueSportCategory record);

    int updateByPrimaryKey(VenueSportCategory record);
}