package com.bsehk.business.service;

import com.bsehk.business.service.vo.ExerciseCourseTimeVO;

import java.util.List;

public interface ExerciseCourseTimeService {
    List<ExerciseCourseTimeVO> listExerciseCourseTime(List<Long> exerciseFieldIds,boolean isDelete);
}
