package com.bsehk.business.service;


import com.bsehk.business.domain.VenueFunctionZone;

import java.util.List;

public interface VenueFunctionZoneService {
//    查询场馆下的功能区列表
    public List<VenueFunctionZone> listByVenueId(Long venueId, Boolean isDelete);

}
