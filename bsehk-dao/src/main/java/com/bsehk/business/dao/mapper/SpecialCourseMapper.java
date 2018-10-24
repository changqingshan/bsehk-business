package com.bsehk.business.dao.mapper;

import com.bsehk.business.domain.SpecialCourse;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

public interface SpecialCourseMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SpecialCourse record);

    int insertSelective(SpecialCourse record);

    SpecialCourse selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SpecialCourse record);

    int updateByPrimaryKeyWithBLOBs(SpecialCourse record);

    int updateByPrimaryKey(SpecialCourse record);

    SpecialCourse selectByVenueId(@Param("venueId") Long venueId,@Param("date") Date date,@Param("isDelete") Boolean isDelete);
}