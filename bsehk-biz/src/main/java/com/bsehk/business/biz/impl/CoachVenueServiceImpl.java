package com.bsehk.business.biz.impl;

import com.bsehk.business.dao.mapper.CoachVenueMapper;
import com.bsehk.business.service.CoachVenueService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
@Slf4j
public class CoachVenueServiceImpl implements CoachVenueService {
    @Resource
    CoachVenueMapper coachVenueMapper;
    @Override
    public List<Long> selectByVenueId(Long venueId) {
        return coachVenueMapper.selectByVenueId(venueId);
    }
}
