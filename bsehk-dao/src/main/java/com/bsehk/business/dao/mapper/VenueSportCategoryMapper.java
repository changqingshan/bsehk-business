package com.bsehk.business.dao.mapper;

import com.bsehk.business.domain.VenueSport;
import com.bsehk.business.domain.VenueSportCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VenueSportCategoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(VenueSportCategory record);

    int insertSelective(VenueSportCategory record);

    VenueSportCategory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(VenueSportCategory record);

    int updateByPrimaryKey(VenueSportCategory record);

    List<VenueSport> listVenueSport( List<Long> venueIds);
}