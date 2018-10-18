package com.bsehk.business.biz.impl;

import com.bsehk.business.dao.mapper.BrandMapper;
import com.bsehk.business.domain.Brand;
import com.bsehk.business.domain.Venue;
import com.bsehk.business.service.BrandService;
import com.bsehk.business.service.VenueService;
import com.bsehk.common.exception.BizException;
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
        if(venue.getBrandId()==null){
            throw new BizException("该场馆没有品牌介绍");
        }
        Brand brand = brandMapper.selectByPrimaryKey(venue.getBrandId());
        return brand;
    }
}
