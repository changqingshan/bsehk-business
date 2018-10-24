package com.bsehk.business.biz.impl;

import com.bsehk.business.dao.mapper.VenueInfrastructureMapper;
import com.bsehk.business.domain.VenueInfrastructureInfo;
import com.bsehk.business.service.VenueInfrastructureService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class VenueInfrastructureServiceImpl implements VenueInfrastructureService {
    @Resource
    VenueInfrastructureMapper venueInfrastructureMapper;
    @Override
    public List<VenueInfrastructureInfo> selectVenueInfrastructureInfoByVenueId(Long venueId,Boolean isDelete) {
        return venueInfrastructureMapper.selectVenueInfrastructureInfoByVenueId(venueId,isDelete);
    }


    @Override
    public List<VenueInfrastructureInfo> pageVenueInfrastructureInfoByVenueId(Long venueId, Integer pageNum, Integer pageSize,Boolean isDelete) {
        PageHelper.startPage(pageNum,pageSize);
        return venueInfrastructureMapper.selectVenueInfrastructureInfoByVenueId(venueId,false);
    }
}
