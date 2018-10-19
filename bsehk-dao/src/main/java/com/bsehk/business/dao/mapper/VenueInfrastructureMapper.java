package com.bsehk.business.dao.mapper;

import com.bsehk.business.domain.VenueInfrastructure;
import com.bsehk.business.domain.VenueInfrastructureInfo;

import java.util.List;

public interface VenueInfrastructureMapper {
    int deleteByPrimaryKey(Long id);

    int insert(VenueInfrastructure record);

    int insertSelective(VenueInfrastructure record);

    VenueInfrastructure selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(VenueInfrastructure record);

    int updateByPrimaryKey(VenueInfrastructure record);

    List<VenueInfrastructureInfo> selectVenueInfrastructureInfoByVenueId(Long venueId);
}