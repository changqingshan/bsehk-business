package com.bsehk.business.dao.mapper;

import com.bsehk.business.domain.CoachMedia;

public interface CoachMediaMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CoachMedia record);

    int insertSelective(CoachMedia record);

    CoachMedia selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CoachMedia record);

    int updateByPrimaryKey(CoachMedia record);
}