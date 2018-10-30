package com.bsehk.business.dao.mapper;

import com.bsehk.business.domain.VenueBannerCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VenueBannerCategoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(VenueBannerCategory record);

    int insertSelective(VenueBannerCategory record);

    VenueBannerCategory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(VenueBannerCategory record);

    int updateByPrimaryKey(VenueBannerCategory record);

    List<VenueBannerCategory> listByIds(@Param("list") List<Long> venueBannerCategoryIds,@Param("isDelete") Boolean isDelete);

}