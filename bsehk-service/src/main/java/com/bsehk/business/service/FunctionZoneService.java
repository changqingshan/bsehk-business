package com.bsehk.business.service;

import com.bsehk.business.domain.FunctionZone;

import java.util.List;

public interface FunctionZoneService {
    List<FunctionZone> listByIds(List<Long> functionZoneIds, Boolean isDelete);
}
