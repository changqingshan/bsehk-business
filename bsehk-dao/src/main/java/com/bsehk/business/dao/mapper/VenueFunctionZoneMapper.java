package com.bsehk.business.dao.mapper;

import com.bsehk.business.domain.VenueFunctionZone;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VenueFunctionZoneMapper {
    int deleteByPrimaryKey(Long id);

    int insert(VenueFunctionZone record);

    int insertSelective(VenueFunctionZone record);

    VenueFunctionZone selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(VenueFunctionZone record);

    int updateByPrimaryKey(VenueFunctionZone record);

    List<VenueFunctionZone> listByVenueId(@Param("venueId") Long venueId, @Param("isDelete") Boolean isDelete);
}