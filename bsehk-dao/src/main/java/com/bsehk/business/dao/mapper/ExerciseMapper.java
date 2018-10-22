package com.bsehk.business.dao.mapper;

import com.bsehk.business.domain.Exercise;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExerciseMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Exercise record);

    int insertSelective(Exercise record);

    Exercise selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Exercise record);

    int updateByPrimaryKey(Exercise record);

    List<Exercise> listByVenueId(@Param("venueId") Long venueId,@Param("isDeleted") Boolean isDeleted);
}