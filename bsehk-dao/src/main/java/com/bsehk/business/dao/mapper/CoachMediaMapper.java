package com.bsehk.business.dao.mapper;

import com.bsehk.business.domain.Coach;
import com.bsehk.business.domain.CoachMedia;

import java.util.List;

public interface CoachMediaMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CoachMedia record);

    int insertSelective(CoachMedia record);

    CoachMedia selectByPrimaryKey(Long id);

    List<CoachMedia> selectByCoachId(List<Coach> coacheList);

    int updateByPrimaryKeySelective(CoachMedia record);

    int updateByPrimaryKey(CoachMedia record);

    List<CoachMedia> selectOneByCochId(Long venueId);
}