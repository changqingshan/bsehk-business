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
    public VenueAdvert selectAdvertByVenueId(Long venueId,Boolean isDelete) {
        Date now = new Date();

        VenueAdvert venueAdvert = venueAdvertMapper.selectAdvertByVenueId(venueId,now,isDelete);

        return venueAdvert;
    }
}
