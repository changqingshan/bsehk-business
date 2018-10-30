package com.bsehk.business.service.vo;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * Created by 24398 on 2018/10/29.
 */
@Data
@Builder
public class ExerciseCourseTimeVO {

    private Long exerciseCourseTimeId;      //节次id
    private Long exerciesFieldId;           //场地id
    private Integer ordinal;
    private String startTime;
    private String endTime;
    private List<WeekDayExercise> weekDayExercises;

    @Data
    @Builder
    public static class WeekDayExercise{
        private Byte week ;
        private String coachName;
        private String exerciseName;
    }

}
