package com.bsehk.business.biz.impl;

import com.bsehk.business.dao.mapper.ExerciseMapper;
import com.bsehk.business.domain.Coach;
import com.bsehk.business.domain.Exercise;
import com.bsehk.business.service.CoachService;
import com.bsehk.business.service.ExerciseService;
import com.bsehk.business.service.vo.ExerciseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ExerciseServiceImpl implements ExerciseService {

    @Resource
    ExerciseMapper exerciseMapper;
    @Resource
    private CoachService coachService;

    public List<ExerciseVo> selectAllExercise(){
       List<ExerciseVo> exerciseVoList=new ArrayList<>();
//       获取所有的课程
       List<Exercise> exercises= exerciseMapper.selectAllExercise();
       if(exercises == null || exercises.isEmpty()){
           return Collections.emptyList();
       }
        List<Long> coachIds = exercises.parallelStream().map(Exercise::getCoachId).collect(Collectors.toList());
        List<Coach> coaches = this.coachService.listByIds(coachIds);

        for (int i=0;i<exercises.size();i++){
            Long coachId=exercises.get(i).getCoachId();
        }

        return null;
    }
}
