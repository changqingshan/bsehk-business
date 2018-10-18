package com.bsehk.business.biz.impl;

import com.bsehk.business.dao.mapper.BrandMapper;

import com.bsehk.business.dao.mapper.VenueMapper;

import com.bsehk.business.domain.Brand;
import com.bsehk.business.service.BrandService;
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
    VenueMapper venueMapper;

    public Brand selectBrandById(long id) {
        Brand brand = brandMapper.selectByPrimaryKey(id);
        return brand;
    }

    @Override
    public Brand selectBrandByVenueId(Long venueId) {
        return null;

    }
}
