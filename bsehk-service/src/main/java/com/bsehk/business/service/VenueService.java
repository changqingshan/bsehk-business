package com.bsehk.business.service;

import com.bsehk.business.domain.Venue;

import com.bsehk.business.service.vo.VenueBriefVO;

import com.bsehk.business.service.vo.VenueComplexVO;

import com.bsehk.business.service.vo.VenueInfoVo;
import com.bsehk.common.util.PageInfo;


import java.util.List;

public interface VenueService {


    PageInfo<List<VenueBriefVO>> searchVenue(Long cityId, Long sportCategoryId, Double longitude, Double latitude, String venueName, Integer pageNum, Integer pageSize);

    Venue selectByPrimaryKey(Long id);

//    获取场馆基础信息
    VenueInfoVo selectVenueInfoById(Long venueId);

    VenueComplexVO getVenueComplexInfo(Long venueId);
}
