package com.bsehk.business.dao.mapper;

import com.bsehk.business.domain.CoachSport;

public interface CoachSportMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CoachSport record);

    int insertSelective(CoachSport record);

    CoachSport selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CoachSport record);

    int updateByPrimaryKey(CoachSport record);
}