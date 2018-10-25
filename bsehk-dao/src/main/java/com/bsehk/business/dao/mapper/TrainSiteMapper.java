package com.bsehk.business.dao.mapper;

import com.bsehk.business.domain.TrainSite;
import com.bsehk.business.domain.TrainSiteInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TrainSiteMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TrainSite record);

    int insertSelective(TrainSite record);

    TrainSite selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TrainSite record);

    int updateByPrimaryKey(TrainSite record);

    List<TrainSiteInfo> listTrainSiteInfo(@Param("venueId") Long venueId, @Param("provinceId") Long provinceId,
                                          @Param("cityId") Long cityId,@Param("districtId") Long districtId,
                                          @Param("isDelete") Boolean isDelete);

    Integer getTrainSiteNumber(@Param("venueId") Long venueId, @Param("isDelete") Boolean isDelete);
}