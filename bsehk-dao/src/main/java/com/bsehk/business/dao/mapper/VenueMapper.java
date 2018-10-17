package com.bsehk.business.dao.mapper;

import com.bsehk.business.domain.Venue;


public interface VenueMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Venue record);

    int insertSelective(Venue record);

    Venue selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Venue record);

    int updateByPrimaryKey(Venue record);
}