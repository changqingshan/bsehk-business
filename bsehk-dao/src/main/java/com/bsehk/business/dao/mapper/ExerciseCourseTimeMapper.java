package com.bsehk.business.dao.mapper;

import com.bsehk.business.domain.ExerciseCourseTime;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExerciseCourseTimeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ExerciseCourseTime record);

    int insertSelective(ExerciseCourseTime record);

    ExerciseCourseTime selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ExerciseCourseTime record);

    int updateByPrimaryKey(ExerciseCourseTime record);

    List<ExerciseCourseTime> listExerciseCourseTime(@Param("exerciseFieldIds") List<Long> exerciseFieldIds,@Param("isDelete") boolean isDelete);
}