package com.bsehk.business.dao.mapper;

import com.bsehk.business.domain.Production;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Production record);

    int insertSelective(Production record);

    Production selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Production record);

    int updateByPrimaryKey(Production record);

    Long numberByVenueId(@Param("venueId") Long venueId,@Param("isDelete")Boolean isDelete);

    List<Production> listByVenueId(@Param("venueId") Long venueId,@Param("isDelete") Boolean isDelete);

    List<Production> listByIds(@Param("list") List<Long> productionIds,@Param("isDelete") Boolean isDelete);
}