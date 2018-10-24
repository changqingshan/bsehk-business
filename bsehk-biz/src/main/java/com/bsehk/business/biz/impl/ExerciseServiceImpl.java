package com.bsehk.business.biz.impl;

import com.bsehk.business.dao.mapper.ExerciseMapper;
import com.bsehk.business.domain.*;
import com.bsehk.business.service.*;
import com.bsehk.business.service.vo.ExerciseComplexVO;
import com.bsehk.business.service.vo.ExerciseVO;
import com.bsehk.business.service.vo.SpecialCourseVO;
import com.bsehk.common.util.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ExerciseServiceImpl implements ExerciseService {

    @Resource
    ExerciseMapper exerciseMapper;
    @Resource
    private VenueNoticeService venueNoticeService;
    @Resource
    private SpecialCourseService specialCourseService;
    @Resource
    private CoachService coachService;
    @Resource
    private ExerciseFieldNoticeService exerciseFieldNoticeService;
    @Resource
    private ExerciseFieldService exerciseFieldService;
    @Resource
    private ExerciseFieldRelationService exerciseFieldRelationService;


    @Override
    public List<ExerciseVO> listVenueExercise(Long venueId) {
          // 查询所有的团操
        List<Exercise> exercises = this.exerciseMapper.listByVenueId(venueId,false);
        if(exercises == null || exercises.isEmpty()){
            return Collections.emptyList();
        }

         // 查询团操课场地教练关系表
        List<Long> exerciseIds = exercises.parallelStream().map(Exercise::getId).collect(Collectors.toList());

        List<ExerciseFieldRelation> exerciseFieldRelations = this.exerciseFieldRelationService.listByExerciseIds(exerciseIds,false);
        // 查询场地
        List<Long> exerciseFieldIds = exerciseFieldRelations.parallelStream().map(ExerciseFieldRelation::getExerciseFieldId).distinct().collect(Collectors.toList());
        List<ExerciseField> exerciseFields = this.exerciseFieldService.listByIds(exerciseFieldIds,false);
        Map<Long,ExerciseField> exerciseFieldMap = exerciseFields.parallelStream().collect(Collectors.toMap(ExerciseField::getId, Function.identity()));
        // 查询场地通知
        List<ExerciseFieldNotice> exerciseFieldNotices = this.exerciseFieldNoticeService.listByExerciseFieldIds(exerciseFieldIds,false);
        Map<Long,ExerciseFieldNotice> exerciseFieldNoticeMap = exerciseFieldNotices.parallelStream().collect(Collectors.toMap(ExerciseFieldNotice::getExerciseFieldId,Function.identity()));
        // 查询教练
        List<Long> coachIds = exerciseFieldRelations.parallelStream().map(ExerciseFieldRelation::getCoachId).distinct().collect(Collectors.toList());
        List<Coach> coaches = this.coachService.listByIds(coachIds,false);
        Map<Long,String> coachIdNameMap = coaches.parallelStream().collect(Collectors.toMap(Coach::getId,Coach::getCoachName));
        // 组合数据

        Map<Long,List<ExerciseFieldRelation>>  relationMap = exerciseFieldRelations.parallelStream().collect(Collectors.groupingBy(ExerciseFieldRelation::getExerciseFieldId));
        List<ExerciseVO> exerciseVOS = new ArrayList<>();
        relationMap.forEach((k,v) ->{
            ExerciseVO exerciseVO = ExerciseVO.builder().filedName(exerciseFieldMap.get(k).getField())
                                                        .exerciseFieldNotice(exerciseFieldNoticeMap.get(k))
                                                        .weekDayExercises(new ArrayList<>())
                                                        .build();

            Map<Long,Long> exerciseCoachMap = v.parallelStream().collect(Collectors.toMap(ExerciseFieldRelation::getExerciseId,ExerciseFieldRelation::getCoachId));
            // 过滤该场馆下的团操
            List<Exercise> venueExercises = exercises.stream().filter(exercise -> v.parallelStream().anyMatch(exerciseFieldRelation ->
                                                                    exerciseFieldRelation.getExerciseId().equals(exercise.getId()))
                                                            ).collect(Collectors.toList());


            // 根据周次进行分类
            Map<Byte,List<Exercise>> weekExerciseMap = venueExercises.stream().collect(Collectors.groupingBy(Exercise::getWeek));
            List<ExerciseVO.WeekDayExercise> weekDayExercises = new ArrayList<>();
            weekExerciseMap.forEach((m,n)->{
                ExerciseVO.WeekDayExercise weekDayExercise = ExerciseVO.WeekDayExercise.builder().week(m.intValue())
                                                                          .innerExercises(new ArrayList<>())
                                                                          .build();
                 // 对每天的团操按开始时间进行排序
                n.sort((o1, o2) -> {
                    if(o1.getExerciseStart().getTime() > o2.getExerciseStart().getTime()){
                        return  1;
                    }else if(o1.getExerciseStart().getTime() < o2.getExerciseStart().getTime()){
                        return -1;
                    }else{
                        return 0;
                    }
                });


                List<ExerciseVO.InnerExercise> innerExercises = n.stream().map(exercise -> ExerciseVO.InnerExercise.builder()
                                                                   .id(exercise.getId())
                                                                   .exerciseName(exercise.getExerciseName())
                                                                   .exerciseStart(DateUtil.date2Str(exercise.getExerciseStart(),"HH:mm"))
                                                                   .exerciseEnd(DateUtil.date2Str(exercise.getExerciseEnd(),"HH:mm"))
                                                                   .coachName(coachIdNameMap.get(exerciseCoachMap.get(exercise.getId())))
                                                                   .build())
                                                                       .collect(Collectors.toList());


                weekDayExercise.setInnerExercises(innerExercises);
                weekDayExercises.add(weekDayExercise);
            });
            exerciseVO.setWeekDayExercises(weekDayExercises);
            exerciseVOS.add(exerciseVO);

        });


        return exerciseVOS;
    }


    @Override
    public ExerciseComplexVO detailExerciseCourse(Long venueId) {
        // 团操课表
        List<ExerciseVO> exerciseVOS = this.listVenueExercise(venueId);
        // 特色课程
        SpecialCourse specialCourse = this.specialCourseService.getByVenueId(venueId,false);
        SpecialCourseVO specialCourseVO = new SpecialCourseVO();
        BeanUtils.copyProperties(specialCourse,specialCourseVO);

        ExerciseComplexVO exerciseComplexVO = ExerciseComplexVO.builder()
                                                              .exerciseVOS(exerciseVOS)
                                                              .specialCourseVO(specialCourseVO)
                                                              .build();


        return exerciseComplexVO;
    }
}
