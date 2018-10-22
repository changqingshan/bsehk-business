package com.bsehk.business.dao.mapper;

import com.bsehk.business.domain.VenueNotice;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

public interface VenueNoticeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(VenueNotice record);

    int insertSelective(VenueNotice record);

    VenueNotice selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(VenueNotice record);

    int updateByPrimaryKey(VenueNotice record);

    VenueNotice selectByVenueIdAndType(@Param("venueId") Long venueId, @Param("noticeType") Integer noticeType, @Param("date") Date date, @Param("isDelete") Boolean isDelete);
}