package com.bsehk.business.dao.mapper;

import com.bsehk.business.domain.ExerciseFieldRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExerciseFieldRelationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ExerciseFieldRelation record);

    int insertSelective(ExerciseFieldRelation record);

    ExerciseFieldRelation selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ExerciseFieldRelation record);

    int updateByPrimaryKey(ExerciseFieldRelation record);

    List<ExerciseFieldRelation> listByExerciseIds(@Param("list") List<Long> exerciseIds, @Param("isDeleted") Boolean isDeleted);
}