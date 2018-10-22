package com.bsehk.business.biz.impl;

import com.bsehk.business.dao.mapper.ExerciseFieldMapper;
import com.bsehk.business.domain.ExerciseField;
import com.bsehk.business.service.ExerciseFieldService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

@Service
@Slf4j
public class ExerciseFieldServiceImpl implements ExerciseFieldService {

    @Resource
    private ExerciseFieldMapper exerciseFieldMapper;

    @Override
    public List<ExerciseField> listByIds(List<Long> exerciseFieldIds,Boolean isDeleted) {
        if(exerciseFieldIds == null || exerciseFieldIds.isEmpty()){
            return Collections.emptyList();
        }
        List<ExerciseField> exerciseFields = this.exerciseFieldMapper.listByIds(exerciseFieldIds,isDeleted);
        return exerciseFields;
    }
}
