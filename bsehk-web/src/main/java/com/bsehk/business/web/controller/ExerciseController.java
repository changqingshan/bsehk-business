package com.bsehk.business.web.controller;

import com.bsehk.business.service.ExerciseService;
import com.bsehk.business.service.vo.ExerciseVo;
import com.bsehk.common.exception.BizException;
import com.bsehk.common.response.ResultData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


@RestController
@Slf4j
@RequestMapping("/exercise")
public class ExerciseController {
    @Resource
    ExerciseService exerciseService;
    /**
     * 查询所有团操课程
     */
@RequestMapping("/selectAllExercise")
    public ResultData selectAllExercise(){
        List<ExerciseVo> exerciseVoList =exerciseService.selectAllExercise();
        if (exerciseVoList.size()==0){
            throw new BizException("没有团体操课程");
        }
        return  ResultData.success(exerciseVoList);

}

}
