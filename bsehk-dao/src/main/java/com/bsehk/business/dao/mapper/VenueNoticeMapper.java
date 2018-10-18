package com.bsehk.business.dao.mapper;

import com.bsehk.business.domain.VenueNotice;

import java.util.List;

public interface VenueNoticeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(VenueNotice record);

    int insertSelective(VenueNotice record);

    VenueNotice selectByPrimaryKey(Long id);

    VenueNotice selectNoticeByVenueId(Long venueId);

    int updateByPrimaryKeySelective(VenueNotice record);

    int updateByPrimaryKey(VenueNotice record);
}