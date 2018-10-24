package com.bsehk.business.service;

import com.bsehk.business.domain.ExerciseFieldNotice;

import java.util.List;

/**
 * Created by 24398 on 2018/10/23.
 */
public interface ExerciseFieldNoticeService {

    List<ExerciseFieldNotice>  listByExerciseFieldIds(List<Long> exerciseFieldIds,Boolean isDelete);

}
