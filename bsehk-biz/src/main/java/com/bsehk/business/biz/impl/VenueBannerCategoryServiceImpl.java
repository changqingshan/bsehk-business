package com.bsehk.business.biz.impl;

import com.bsehk.business.dao.mapper.VenueBannerCategoryMapper;
import com.bsehk.business.domain.VenueBannerCategory;
import com.bsehk.business.service.VenueBannerCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

/**
 * Created by 24398 on 2018/10/24.
 */

@Service
@Slf4j
public class VenueBannerCategoryServiceImpl implements VenueBannerCategoryService {

    @Resource
    private VenueBannerCategoryMapper venueBannerCategoryMapper;

    @Override
    public List<VenueBannerCategory> listByIds(List<Long> venueBannerCategoryIds, Boolean isDelete) {
        if(venueBannerCategoryIds == null || venueBannerCategoryIds.isEmpty()){
            return Collections.emptyList();
        }
        List<VenueBannerCategory> venueBannerCategories = this.venueBannerCategoryMapper.listByIds(venueBannerCategoryIds,isDelete);
        return venueBannerCategories;
    }

}
