package com.bsehk.business.service;

import com.bsehk.business.domain.Venue;
import com.bsehk.business.service.vo.VenueBriefVO;

import java.util.List;

public interface VenueService {

    List<VenueBriefVO> searchVenue(Long cityId,Long sportCategoryId,double longitude,double latitude,String venueName);

    Venue selectByPrimaryKey(Long id);

}
