package com.bsehk.business.service;

import com.bsehk.business.domain.Venue;

import com.bsehk.business.service.vo.VenueBriefVO;
import com.bsehk.business.service.vo.VenueVo;
import javafx.beans.binding.DoubleExpression;

import java.util.List;

public interface VenueService {
VenueVo selectVenueById(long id);

    List<VenueBriefVO> searchVenue(Long cityId, Long sportCategoryId, Double longitude, Double latitude, String venueName);


    Venue selectByPrimaryKey(Long id);


}
