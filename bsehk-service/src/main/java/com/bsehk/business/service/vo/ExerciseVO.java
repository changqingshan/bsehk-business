package com.bsehk.business.service.vo;

import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Builder
public class ExerciseVO {

    private String filedName;
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
        private Date exerciseStart;
        private Date exerciseEnd;
    }

}
