package com.bsehk.business.dao.mapper;

import com.bsehk.business.domain.Venue;
import com.bsehk.business.domain.VenueSport;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface VenueMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Venue record);

    int insertSelective(Venue record);

    Venue selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Venue record);

    int updateByPrimaryKey(Venue record);

    List<Venue> searchVenue(@Param("cityId") Long cityId, @Param("list") List<Long> sportCategoryIds, @Param("venueName") String venueName);

    Long searchVenueNum(@Param("cityId")Long cityId, @Param("list") List<Long> sportCategoryIds, @Param("venueName")String venueName);
}