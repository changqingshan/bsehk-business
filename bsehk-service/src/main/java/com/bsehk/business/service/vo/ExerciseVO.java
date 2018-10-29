package com.bsehk.business.service.vo;

import com.bsehk.business.domain.ExerciseFieldNotice;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Builder
public class ExerciseVO {

    private String filedName;
    private ExerciseFieldNotice exerciseFieldNotice;
    private List<ExerciseCourseTimeVO> exerciseCourseTimeVOS;
    List<WeekDayExercise> weekDayExercises;


    @Data
    @Builder
    public static class WeekDayExercise{
         private Integer week ;
         List<InnerExercise>  innerExercises;

    }

    @Data
    @Builder
    public static class InnerExercise{
        private Long id;
        private String coachName;
        private String exerciseName;
        private Integer ordinal; // 节次
    }

}
