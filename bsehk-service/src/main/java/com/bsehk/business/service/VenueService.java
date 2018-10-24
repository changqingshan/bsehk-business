package com.bsehk.business.service;

import com.bsehk.business.domain.Venue;

import com.bsehk.business.service.vo.VenueBriefVO;
import com.bsehk.business.service.vo.VenueComplexVO;


import java.util.List;

public interface VenueService {


    List<VenueBriefVO> searchVenue(Long cityId, Long sportCategoryId, Double longitude, Double latitude, String venueName);


    Venue selectByPrimaryKey(Long id);


    VenueComplexVO getVenueComplexInfo(Long venueId);
}
