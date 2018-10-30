package com.bsehk.business.service.vo;

import com.bsehk.business.domain.ExerciseFieldNotice;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExerciseVO {

    private Long exerciesFieldId;   //场地id
    private String filedName;       //场地名称
    private ExerciseFieldNotice exerciseFieldNotice;        //团操课通知
    private List<ExerciseCourseTimeVO> exerciseCourseTimeVOS;   //团操课节次信息



}
