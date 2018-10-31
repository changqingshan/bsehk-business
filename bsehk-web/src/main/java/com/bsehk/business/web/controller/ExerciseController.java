package com.bsehk.business.web.controller;

import com.bsehk.business.service.ExerciseService;
import com.bsehk.business.service.vo.ExerciseComplexVO;
import com.bsehk.business.service.vo.ExerciseVO;
import com.bsehk.common.exception.BizException;
import com.bsehk.common.response.ResultData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


@RestController
@Slf4j
@RequestMapping("/exercise")
public class ExerciseController {
    @Resource
    ExerciseService exerciseService;

    //团操课展示接口
    @RequestMapping("/exerciseCourse")
    public ResultData detailExerciseCourse(Long venueId){
        ExerciseComplexVO exerciseComplexVO = this.exerciseService.detailExerciseCourse(venueId);
        return ResultData.success(exerciseComplexVO);
    }

}
