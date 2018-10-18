package com.bsehk.business.service;

import com.bsehk.business.domain.VenueBanner;
import com.bsehk.business.service.vo.VenueBannerVO;

import java.util.List;

public interface VenueBannerService {
    List<VenueBannerVO> selectBannerByVenueId(Long venueId);
}
