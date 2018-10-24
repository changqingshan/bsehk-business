package com.bsehk.business.service;


import com.bsehk.business.service.vo.ExerciseComplexVO;
import com.bsehk.business.service.vo.ExerciseVO;

import java.util.List;
import java.util.Map;

public interface ExerciseService {
    List<ExerciseVO> listVenueExercise(Long venueId);

    ExerciseComplexVO detailExerciseCourse(Long venueId);
}
