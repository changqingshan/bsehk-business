package com.bsehk.business.biz.impl;

import com.bsehk.business.dao.mapper.BrandMapper;
import com.bsehk.business.domain.Brand;
import com.bsehk.business.domain.Venue;
import com.bsehk.business.service.BrandService;
import com.bsehk.business.service.VenueService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by 24398 on 2018/10/17.
 */
@Service
@Slf4j
public class BrandServiceImpl implements BrandService {
    @Resource
    BrandMapper brandMapper;
    @Resource
    VenueService venueService;

    @Override
    public Brand selectBrandByVenueId(Long venueId) {

        Venue venue = venueService.selectByPrimaryKey(venueId);
        if(venue == null){
            return null;
        }
        Brand brand = brandMapper.selectByPrimaryKey(venue.getBrandId());
        return brand;
    }
}
