package com.bsehk.business.dao.mapper;

import com.bsehk.business.domain.VenueServiceSite;

public interface VenueServiceSiteMapper {
    int deleteByPrimaryKey(Long id);

    int insert(VenueServiceSite record);

    int insertSelective(VenueServiceSite record);

    VenueServiceSite selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(VenueServiceSite record);

    int updateByPrimaryKey(VenueServiceSite record);
}