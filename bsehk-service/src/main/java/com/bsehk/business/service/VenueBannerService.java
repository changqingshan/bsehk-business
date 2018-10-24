package com.bsehk.business.service;

import com.bsehk.business.service.vo.VenueBannerVO;

import java.util.List;

public interface VenueBannerService {
    List<VenueBannerVO> selectBannerByVenueId(Long venueId);



    Integer numberBanner(Long venueId, Boolean isDelete);
}
