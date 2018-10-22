package com.bsehk.business.service;

import com.bsehk.business.domain.ExerciseFieldRelation;

import java.util.List;

/**
 * Created by 24398 on 2018/10/20.
 */
public interface ExerciseFieldRelationService {
    List<ExerciseFieldRelation> listByExerciseIds(List<Long> exerciseIds,Boolean isDeleted);
}
