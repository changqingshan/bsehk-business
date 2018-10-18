package com.bsehk.business.dao.mapper;

import com.bsehk.business.domain.VenueBanner;

import java.util.List;

public interface VenueBannerMapper {
    int deleteByPrimaryKey(Long id);

    int insert(VenueBanner record);

    int insertSelective(VenueBanner record);

    VenueBanner selectByPrimaryKey(Long id);

    List<VenueBanner> selectBannerByVenueId(Long venueId);

    int updateByPrimaryKeySelective(VenueBanner record);

    int updateByPrimaryKey(VenueBanner record);
}