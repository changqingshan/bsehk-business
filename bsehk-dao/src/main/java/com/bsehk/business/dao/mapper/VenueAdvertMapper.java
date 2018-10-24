package com.bsehk.business.dao.mapper;

import com.bsehk.business.domain.VenueAdvert;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

public interface VenueAdvertMapper {
    int deleteByPrimaryKey(Long id);

    int insert(VenueAdvert record);

    int insertSelective(VenueAdvert record);

    VenueAdvert selectByPrimaryKey(Long id);

    VenueAdvert selectAdvertByVenueId(@Param("venueId") Long venueId, @Param("date") Date now , @Param("isDelete") Boolean isDelete);

    int updateByPrimaryKeySelective(VenueAdvert record);

    int updateByPrimaryKey(VenueAdvert record);
}