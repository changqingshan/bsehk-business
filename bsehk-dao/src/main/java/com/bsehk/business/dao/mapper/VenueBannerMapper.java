package com.bsehk.business.dao.mapper;

import com.bsehk.business.domain.VenueBanner;

public interface VenueBannerMapper {
    int deleteByPrimaryKey(Long id);

    int insert(VenueBanner record);

    int insertSelective(VenueBanner record);

    VenueBanner selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(VenueBanner record);

    int updateByPrimaryKey(VenueBanner record);
}