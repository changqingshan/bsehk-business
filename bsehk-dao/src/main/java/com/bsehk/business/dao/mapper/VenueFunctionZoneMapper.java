package com.bsehk.business.dao.mapper;

import com.bsehk.business.domain.VenueFunctionZone;
import com.bsehk.business.domain.VenueFunctionZoneInfo;

import java.util.List;

public interface VenueFunctionZoneMapper {
    int deleteByPrimaryKey(Long id);

    int insert(VenueFunctionZone record);

    int insertSelective(VenueFunctionZone record);

    VenueFunctionZone selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(VenueFunctionZone record);

    int updateByPrimaryKey(VenueFunctionZone record);

    List<VenueFunctionZoneInfo> selectVenueFunctionZoneInfoByVenueId(Long venueId);

}