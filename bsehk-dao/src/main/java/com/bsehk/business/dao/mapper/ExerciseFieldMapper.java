package com.bsehk.business.dao.mapper;

import com.bsehk.business.domain.ExerciseField;

public interface ExerciseFieldMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ExerciseField record);

    int insertSelective(ExerciseField record);

    ExerciseField selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ExerciseField record);

    int updateByPrimaryKey(ExerciseField record);
}