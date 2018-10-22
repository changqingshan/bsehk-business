package com.bsehk.business.service;


import com.bsehk.business.domain.VenueFunctionZoneInfo;

import java.util.List;

public interface VenueFunctionZoneService {
    List<VenueFunctionZoneInfo> selectVenueFunctionZoneInfoByVenueId(Long venueId);
}
