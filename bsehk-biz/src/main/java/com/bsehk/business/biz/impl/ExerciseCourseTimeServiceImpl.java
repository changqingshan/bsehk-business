package com.bsehk.business.biz.impl;

import com.bsehk.business.dao.mapper.ExerciseCourseTimeMapper;
import com.bsehk.business.domain.ExerciseCourseTime;
import com.bsehk.business.service.ExerciseCourseTimeService;
import com.bsehk.business.service.vo.ExerciseCourseTimeVO;
import com.bsehk.common.util.DateUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExerciseCourseTimeServiceImpl implements ExerciseCourseTimeService {
    @Resource
    ExerciseCourseTimeMapper exerciseCourseTimeMapper;
    @Override
    public List<ExerciseCourseTimeVO> listExerciseCourseTime(List<Long> exerciseFieldIds,boolean isDelete) {
        List<ExerciseCourseTimeVO> exerciseCourseTimeVOS = new ArrayList<>();
        List<ExerciseCourseTime> exerciseCourseTimes = this.exerciseCourseTimeMapper.listExerciseCourseTime(exerciseFieldIds, isDelete);
        for (ExerciseCourseTime exerciseCourseTime:exerciseCourseTimes) {
            ExerciseCourseTimeVO exerciseCourseTimeVO = ExerciseCourseTimeVO.builder()
                                            .exerciseCourseTimeId(exerciseCourseTime.getId())
                                            .exerciesFieldId(exerciseCourseTime.getExerciseFieldId())
                                            .ordinal(exerciseCourseTime.getOrdinal())
                                            .startTime(DateUtil.date2Str(exerciseCourseTime.getExerciseStart(),"HH:mm"))
                                            .endTime(DateUtil.date2Str(exerciseCourseTime.getExercieseEnd(),"HH:mm"))
                                            .weekDayExercises(new ArrayList<>())
                                            .build();
            exerciseCourseTimeVOS.add(exerciseCourseTimeVO);
        }
        return exerciseCourseTimeVOS;
    }
}
