package com.bsehk.business.biz.impl;

import com.bsehk.business.dao.mapper.VenueMapper;
import com.bsehk.business.domain.FunctionZone;
import com.bsehk.business.domain.Infrastructure;
import com.bsehk.business.domain.Venue;
import com.bsehk.business.service.VenueService;
import com.bsehk.business.service.vo.VenueVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class VenueServiceImpl implements VenueService {
    @Resource
    VenueMapper venueMapper;
    public VenueVo selectVenueById(long id){
       VenueVo venueVo=new VenueVo();
        List<String> sportList=new ArrayList<>();
        List<Infrastructure> infrastructuresList=new ArrayList<>();
        List<FunctionZone> functionZoneList=new ArrayList<>();
         Venue venue=venueMapper.selectByPrimaryKey(id);
         venueVo.setSportList(sportList);
         venueVo.setInfrastructuresList(infrastructuresList);
         venueVo.setFunctionZoneList(functionZoneList);
         venueVo.setVenue(venue);
        return  venueVo;
    }
}
