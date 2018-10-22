package com.bsehk.business.service;


import com.bsehk.business.service.vo.ExerciseVO;

import java.util.List;
import java.util.Map;

public interface ExerciseService {

 List<ExerciseVO> listVenueExercise(Long venueId);

    Map<String,Object> detailExerciseCourse(Long venueId);
}
