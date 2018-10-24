package com.bsehk.business.biz.impl;

import com.bsehk.business.dao.mapper.VenueFunctionZoneMapper;
import com.bsehk.business.domain.VenueFunctionZone;
import com.bsehk.business.service.VenueFunctionZoneService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class VenueFunctionZoneServiceImpl implements VenueFunctionZoneService {
    @Resource
    VenueFunctionZoneMapper venueFunctionZoneMapper;

    public List<VenueFunctionZone> listByVenueId(Long venueId,Boolean isDelete){
        List<VenueFunctionZone> venueFunctionZones = this.venueFunctionZoneMapper.listByVenueId(venueId,isDelete);
        return venueFunctionZones;
    };
}
