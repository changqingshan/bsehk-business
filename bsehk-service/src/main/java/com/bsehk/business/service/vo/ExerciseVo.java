package com.bsehk.business.service.vo;

import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Builder
public class ExerciseVo {

    private String filedName;
    List<WeekDayExercise> weekDayExercises;

    public static class WeekDayExercise{
         private Integer week ;
         List<InnerExercise>  innerExercises;

    }

    public static class InnerExercise{
        private Long id;
        private String coachName;
        private String exerciseName;
        private Date exerciseStart;
        private Date exerciseEnd;
    }

}
