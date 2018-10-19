package com.bsehk.business.biz.impl;

import com.bsehk.business.dao.mapper.VenueInfrastructureMapper;
import com.bsehk.business.domain.VenueInfrastructureInfo;
import com.bsehk.business.service.VenueInfrastructureService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class VenueInfrastructureServiceImpl implements VenueInfrastructureService {
    @Resource
    VenueInfrastructureMapper venueInfrastructureMapper;
    @Override
    public List<VenueInfrastructureInfo> selectVenueInfrastructureInfoByVenueId(Long venueId) {
        return venueInfrastructureMapper.selectVenueInfrastructureInfoByVenueId(venueId);
    }
}
