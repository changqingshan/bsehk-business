package com.bsehk.business.biz.impl;

import com.bsehk.business.dao.mapper.ExerciseFieldNoticeMapper;
import com.bsehk.business.domain.ExerciseFieldNotice;
import com.bsehk.business.service.ExerciseFieldNoticeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Created by 24398 on 2018/10/23.
 */

@Service
@Slf4j
public class ExerciseFieldNoticeServiceImpl implements ExerciseFieldNoticeService {

    @Resource
    private ExerciseFieldNoticeMapper exerciseFieldNoticeMapper;

    @Override
    public List<ExerciseFieldNotice> listByExerciseFieldIds(List<Long> exerciseFieldIds,Boolean isDelete) {
        if(exerciseFieldIds == null || exerciseFieldIds.isEmpty()){
            return Collections.emptyList();
        }

        Date date  = new Date();
        List<ExerciseFieldNotice> exerciseFieldNotices = this.exerciseFieldNoticeMapper.listByExerciseFieldIds(exerciseFieldIds,date,isDelete);

        return exerciseFieldNotices;
    }
}
