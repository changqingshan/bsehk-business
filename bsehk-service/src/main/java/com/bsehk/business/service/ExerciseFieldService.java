package com.bsehk.business.service;

import com.bsehk.business.domain.ExerciseField;

import java.util.List;

public interface ExerciseFieldService {
    List<ExerciseField> listByIds(List<Long> exerciseFieldIds,Boolean isDeleted);
}
