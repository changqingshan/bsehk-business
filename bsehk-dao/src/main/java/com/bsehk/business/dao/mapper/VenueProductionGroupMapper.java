package com.bsehk.business.dao.mapper;

import com.bsehk.business.domain.VenueProductionGroup;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VenueProductionGroupMapper {
    int deleteByPrimaryKey(Long id);

    int insert(VenueProductionGroup record);

    int insertSelective(VenueProductionGroup record);

    VenueProductionGroup selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(VenueProductionGroup record);

    int updateByPrimaryKey(VenueProductionGroup record);

    VenueProductionGroup getDefault(@Param("venueId") Long venueId, @Param("isDefault") Boolean isDefault,@Param("isDelete") Boolean isDelete);

    List<VenueProductionGroup> listByVenueId(@Param("venueId") Long venueId,@Param("isDelete") Boolean isDelete);
}