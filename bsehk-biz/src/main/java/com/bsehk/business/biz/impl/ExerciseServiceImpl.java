package com.bsehk.business.biz.impl;

import com.bsehk.business.dao.mapper.ExerciseMapper;
import com.bsehk.business.domain.*;
import com.bsehk.business.service.*;
import com.bsehk.business.service.vo.ExerciseComplexVO;
import com.bsehk.business.service.vo.ExerciseCourseTimeVO;
import com.bsehk.business.service.vo.ExerciseVO;
import com.bsehk.business.service.vo.SpecialCourseVO;
import com.bsehk.common.util.DateUtil;
import lombok.extern.slf4j.Slf4j;
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
    private SpecialCourseService specialCourseService;
    @Resource
    private CoachService coachService;
    @Resource
    private ExerciseFieldNoticeService exerciseFieldNoticeService;
    @Resource
    private ExerciseFieldService exerciseFieldService;
    @Resource
    private ExerciseFieldRelationService exerciseFieldRelationService;
    @Resource
    private ExerciseCourseTimeService exerciseCourseTimeService;

    @Override
    public List<ExerciseVO> listVenueExercise(Long venueId) {
        // 查询该场馆下所有的团操
        List<Exercise> exercises = this.exerciseMapper.listByVenueId(venueId,false);
        if(exercises == null || exercises.isEmpty()){
            return Collections.emptyList();
        }

        // 查询团操课场地教练关系表
            //获取所有团操id
        List<Long> exerciseIds = exercises.parallelStream().map(Exercise::getId).collect(Collectors.toList());
        List<ExerciseFieldRelation> exerciseFieldRelations = this.exerciseFieldRelationService.listByExerciseIds(exerciseIds,false);
        //log.info("相关的团操场地教练表：exerciseFieldRelations:[{}]",exerciseFieldRelations);
        // 查询场地
            //获取场地id并去重
        List<Long> exerciseFieldIds = exerciseFieldRelations.parallelStream().map(ExerciseFieldRelation::getExerciseFieldId).distinct().collect(Collectors.toList());
        //log.info("相关的场地id：exerciseFieldIds:[{}]",exerciseFieldIds);
        List<ExerciseField> exerciseFields = this.exerciseFieldService.listByIds(exerciseFieldIds,false);
        Map<Long,ExerciseField> exerciseFieldMap = exerciseFields.parallelStream().collect(Collectors.toMap(ExerciseField::getId, Function.identity()));
        //log.info("相关的场地：exerciseFieldMap:[{}]",exerciseFieldMap);
        // 查询场地通知
        List<ExerciseFieldNotice> exerciseFieldNotices = this.exerciseFieldNoticeService.listByExerciseFieldIds(exerciseFieldIds,false);
        Map<Long,ExerciseFieldNotice> exerciseFieldNoticeMap = exerciseFieldNotices.parallelStream().collect(Collectors.toMap(ExerciseFieldNotice::getExerciseFieldId,Function.identity()));
        log.info("exerciseFieldNoticeMap:[{}]",exerciseFieldNoticeMap);
        // 查询教练
        List<Long> coachIds = exerciseFieldRelations.parallelStream().map(ExerciseFieldRelation::getCoachId).distinct().collect(Collectors.toList());
        List<Coach> coaches = this.coachService.listByIds(coachIds,false);
        //log.info("coaches:[{}]",coaches);
        //获取场地节次信息
        List<ExerciseCourseTimeVO> exerciseCourseTimeVOS = this.exerciseCourseTimeService.listExerciseCourseTime(exerciseFieldIds, false);

        //数据组装
            //把团操课按照周次放入对应的节次中  一个节次对应7个周次 每个节次的id不重复
        Map<Long, List<Exercise>> collectMap = exercises.parallelStream().collect(Collectors.groupingBy(Exercise::getExerciseCourseTimeId));

        collectMap.forEach((k,v)->{
            for (ExerciseCourseTimeVO exerciseCourseTimeVO:exerciseCourseTimeVOS) {
                //节次相同的团操课集合拆分到团操课的节次VO中
                if(k .equals( exerciseCourseTimeVO.getExerciseCourseTimeId())){
                    for (Exercise exercise:v) {
                        ExerciseCourseTimeVO.WeekDayExercise weekDayExercise = ExerciseCourseTimeVO.WeekDayExercise.builder()
                                .week(exercise.getWeek())
                                .exerciseName(exercise.getExerciseName())
                                .build();
                        //查找团操场馆关系表中团操课对应的教练id，添加教练姓名
                        for (ExerciseFieldRelation exerciseFieldRelation:exerciseFieldRelations) {
                            for (Coach coach:coaches) {
                                if(exercise.getId().equals(exerciseFieldRelation.getExerciseId())){
                                    if(exerciseFieldRelation.getCoachId() .equals(coach.getId()) ){
                                        weekDayExercise.setCoachName(coach.getCoachName());
                                    }
                                }
                            }
                        }
                        exerciseCourseTimeVO.getWeekDayExercises().add(weekDayExercise);
                    }
                }
            }

        });
        //log.info("相关节次及对应的周次：exerciseCourseTimeVOS:[{}]",exerciseCourseTimeVOS);
        //场地节次信息按照场地分组
        Map<Long, List<ExerciseCourseTimeVO>> map = exerciseCourseTimeVOS.parallelStream().collect(Collectors.groupingBy(ExerciseCourseTimeVO::getExerciesFieldId));
        //log.info("map:[{}]",map);
        //判断场地id与团操课自带的场地id是否相同，相同的把场地信息存入团操课
        List<ExerciseVO> exerciseVOS = new ArrayList<>();
        //判断场地id与场地通知带的场地id是否相同，相同就把场地名与场地通知放入ExerciseVO
        if(exerciseFieldNoticeMap.isEmpty()){
            log.info("===============");
            exerciseFieldMap.forEach((exerciseFieldId,exerciseField)->{
                ExerciseVO exerciseVO = ExerciseVO.builder()
                        .exerciesFieldId(exerciseFieldId)
                        .filedName(exerciseField.getField())
                        .exerciseCourseTimeVOS(new ArrayList<>())
                        .build();
                log.info("exerciseVO:[{}]",exerciseVO);
                exerciseVOS.add(exerciseVO);
            });
        }else {
            exerciseFieldMap.forEach((exerciseFieldId,exerciseField)->{
                exerciseFieldNoticeMap.forEach((noticeExerciseFieldId,exerciseFieldNoticeList)->{
                    if(exerciseFieldId.equals(noticeExerciseFieldId)){
                        ExerciseVO exerciseVO = ExerciseVO.builder()
                                .exerciesFieldId(exerciseFieldId)
                                .filedName(exerciseField.getField())
                                .exerciseFieldNotice(exerciseFieldNoticeList)
                                .exerciseCourseTimeVOS(new ArrayList<>())
                                .build();
                        exerciseVOS.add(exerciseVO);
                    }else {
                        //找不到与场地对应的场地通知则不添加场地通知
                        ExerciseVO exerciseVO = ExerciseVO.builder()
                                .exerciesFieldId(exerciseFieldId)
                                .filedName(exerciseField.getField())
                                .exerciseCourseTimeVOS(new ArrayList<>())
                                .build();
                        log.info("exerciseVO:[{}]",exerciseVO);
                        exerciseVOS.add(exerciseVO);
                    }
                });
            });
        }

        log.info("exerciseVOS:[{}]",exerciseVOS);
        //判断exerciseVO自带的场地id与exerciseCourseTimeVOS的场地id是否相同，相同把exerciseCourseTimeVOS放入exerciseVO的属性中
        for (ExerciseCourseTimeVO exerciseCourseTimeVO:exerciseCourseTimeVOS) {
            for (ExerciseVO exerciseVO:exerciseVOS) {
                if(exerciseCourseTimeVO.getExerciesFieldId().equals(exerciseVO.getExerciesFieldId())){
                    exerciseVO.getExerciseCourseTimeVOS().add(exerciseCourseTimeVO);
                }
            }
        }

        /*exerciseFieldMap.forEach((k,v)->{
            exerciseFieldNoticeMap.forEach((m,n)->{
                if(k.equals(m)){
                    map.forEach((u,i)->{
                        if(k.equals(u)){
                            ExerciseVO exerciseVO = ExerciseVO.builder()
                                    .filedName(v.getField())
                                    .exerciseFieldNotice(n)
                                    .exerciseCourseTimeVOS(i)
                                    .build();
                            log.info("exerciseVO:[{}]",exerciseVO);

                            exerciseVOS.add(exerciseVO);
                        }
                    });

                }
            });
        });*/
        return exerciseVOS;
    }

    @Override
    public ExerciseComplexVO detailExerciseCourse(Long venueId) {
        // 团操课表
        List<ExerciseVO> exerciseVOS = this.listVenueExercise(venueId);
        // 特色课程
        SpecialCourse specialCourse = this.specialCourseService.getByVenueId(venueId,false);
        SpecialCourseVO specialCourseVO = new SpecialCourseVO();
        //log.info("specialCourse:[{}]",specialCourse);
        if(specialCourse == null){
            specialCourseVO =null;
        }else {
            specialCourseVO = SpecialCourseVO.builder()
                                            .title(specialCourse.getTitle())
                                            .intro(specialCourse.getIntro())
                                            .build();
        }


        ExerciseComplexVO exerciseComplexVO = ExerciseComplexVO.builder()
                .exerciseVOS(exerciseVOS)
                .specialCourseVO(specialCourseVO)
                .build();


        return exerciseComplexVO;
    }
}
