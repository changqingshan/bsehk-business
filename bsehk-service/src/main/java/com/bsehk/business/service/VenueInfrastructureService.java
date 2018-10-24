package com.bsehk.business.service;

import com.bsehk.business.domain.VenueInfrastructureInfo;

import java.util.List;

public interface VenueInfrastructureService {
    List<VenueInfrastructureInfo> selectVenueInfrastructureInfoByVenueId(Long venueId,Boolean isDelete);

    List<VenueInfrastructureInfo> pageVenueInfrastructureInfoByVenueId(Long venueId, Integer pageNum, Integer pageSize,Boolean isDelete);
}
