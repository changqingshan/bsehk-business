package com.bsehk.business.dao.mapper;

import com.bsehk.business.domain.VenueNotice;

public interface VenueNoticeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(VenueNotice record);

    int insertSelective(VenueNotice record);

    VenueNotice selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(VenueNotice record);

    int updateByPrimaryKey(VenueNotice record);
}