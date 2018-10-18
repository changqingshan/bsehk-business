package com.bsehk.business.service;


import com.bsehk.business.service.vo.VenueBriefVO;
import com.bsehk.business.service.vo.VenueVo;

import java.util.List;

public interface VenueService {
VenueVo selectVenueById(long id);

    List<VenueBriefVO> searchVenue(Long cityId,Long sportCategoryId,double longitude,double latitude,String venueName);


}
