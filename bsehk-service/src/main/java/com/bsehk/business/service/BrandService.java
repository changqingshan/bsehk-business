package com.bsehk.business.service;

import com.bsehk.business.domain.Brand;

/**
 * Created by 24398 on 2018/10/17.
 */
public interface BrandService {
    Brand selectBrandByVenueId(Long venueId);
}
