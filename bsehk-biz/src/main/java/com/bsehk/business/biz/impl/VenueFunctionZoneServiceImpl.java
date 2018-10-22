package com.bsehk.business.biz.impl;

import com.bsehk.business.dao.mapper.VenueFunctionZoneMapper;
import com.bsehk.business.dao.mapper.VenueInfrastructureMapper;
import com.bsehk.business.domain.VenueFunctionZoneInfo;
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

    @Override
    public List<VenueFunctionZoneInfo> selectVenueFunctionZoneInfoByVenueId(Long venueId) {

        return venueFunctionZoneMapper.selectVenueFunctionZoneInfoByVenueId(venueId);
    }
}
