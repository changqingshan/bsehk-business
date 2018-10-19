package com.bsehk.business.service;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CoachVenueService {
    List<Long> selectByVenueId( Long venueId);
}
