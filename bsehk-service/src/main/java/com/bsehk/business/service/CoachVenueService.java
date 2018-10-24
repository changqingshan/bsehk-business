package com.bsehk.business.service;


import java.util.List;

public interface CoachVenueService {
    List<Long> selectByVenueId( Long venueId);
}
