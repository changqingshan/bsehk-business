package com.bsehk.business.service;

import com.bsehk.business.domain.VenueBannerCategory;

import java.util.List;

/**
 * Created by 24398 on 2018/10/24.
 */
public interface VenueBannerCategoryService {
    List<VenueBannerCategory> listByIds(List<Long> venueBannerCategoryIds, Boolean isDelete);
}
