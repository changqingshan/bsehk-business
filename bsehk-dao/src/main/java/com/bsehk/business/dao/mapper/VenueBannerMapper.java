package com.bsehk.business.dao.mapper;

import com.bsehk.business.domain.VenueBanner;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VenueBannerMapper {
    int deleteByPrimaryKey(Long id);

    int insert(VenueBanner record);

    int insertSelective(VenueBanner record);

    VenueBanner selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(VenueBanner record);

    int updateByPrimaryKey(VenueBanner record);

    List<VenueBanner> selectBannerByVenueId(Long venueId, Boolean  isDelete);

    Integer numberBanner(@Param("venueId") Long venueId,@Param("isDelete") Boolean isDelete);
}