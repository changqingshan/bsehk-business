package com.bsehk.business.dao.mapper;

import com.bsehk.business.domain.VenueAdvert;

public interface VenueAdvertMapper {
    int deleteByPrimaryKey(Long id);

    int insert(VenueAdvert record);

    int insertSelective(VenueAdvert record);

    VenueAdvert selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(VenueAdvert record);

    int updateByPrimaryKey(VenueAdvert record);
}