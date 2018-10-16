package com.bsehk.business.dao.mapper;

import com.bsehk.business.domain.Coach;

public interface CoachMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Coach record);

    int insertSelective(Coach record);

    Coach selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Coach record);

    int updateByPrimaryKey(Coach record);
}