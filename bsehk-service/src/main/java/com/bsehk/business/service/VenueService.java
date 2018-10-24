package com.bsehk.business.service;

import com.bsehk.business.domain.Venue;

import com.bsehk.business.service.vo.VenueBriefVO;

import com.bsehk.business.service.vo.VenueComplexVO;

import com.bsehk.business.service.vo.VenueInfoVo;



import java.util.List;

public interface VenueService {


    List<VenueBriefVO> searchVenue(Long cityId, Long sportCategoryId, Double longitude, Double latitude, String venueName);

    Venue selectByPrimaryKey(Long id);

//    获取场馆基础信息
    VenueInfoVo selectVenueInfoById(Long venueId);

    VenueComplexVO getVenueComplexInfo(Long venueId);
}
