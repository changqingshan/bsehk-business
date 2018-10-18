package com.bsehk.business.dao.mapper;

import com.bsehk.business.domain.Exercise;

import java.util.List;

public interface ExerciseMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Exercise record);

    int insertSelective(Exercise record);

    Exercise selectByPrimaryKey(Long id);

    List<Exercise> selectAllExercise();

    int updateByPrimaryKeySelective(Exercise record);

    int updateByPrimaryKey(Exercise record);
}