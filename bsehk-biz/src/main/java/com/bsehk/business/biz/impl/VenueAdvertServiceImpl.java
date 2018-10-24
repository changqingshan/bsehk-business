package com.bsehk.business.biz.impl;

import com.bsehk.business.dao.mapper.VenueAdvertMapper;
import com.bsehk.business.domain.VenueAdvert;
import com.bsehk.business.service.VenueAdvertService;
import com.bsehk.common.exception.BizException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
@Slf4j
public class VenueAdvertServiceImpl implements VenueAdvertService {
    @Resource
    VenueAdvertMapper venueAdvertMapper;
    @Override
    public VenueAdvert selectAdvertByVenueId(Long venueId) {
        Date nowDate = new Date();

        VenueAdvert venueAdvert = venueAdvertMapper.selectAdvertByVenueId(venueId);
        log.info("venueAdvert ----------> :[{}]",venueAdvert);
        if(venueAdvert.getEndTime().before(nowDate)){
            throw new BizException("没有发布中的广告");
        }
        return venueAdvert;
    }
}
