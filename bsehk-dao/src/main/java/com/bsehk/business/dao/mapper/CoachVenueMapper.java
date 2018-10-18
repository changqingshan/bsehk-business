package com.bsehk.business.dao.mapper;

import com.bsehk.business.domain.CoachVenue;

import java.util.List;

public interface CoachVenueMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CoachVenue record);

    int insertSelective(CoachVenue record);

    CoachVenue selectByPrimaryKey(Long id);

    List<Long> selectByVenueId(Long venueId);

    int updateByPrimaryKeySelective(CoachVenue record);

    int updateByPrimaryKey(CoachVenue record);
}