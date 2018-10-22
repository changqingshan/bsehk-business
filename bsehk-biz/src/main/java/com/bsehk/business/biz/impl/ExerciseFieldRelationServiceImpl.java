package com.bsehk.business.biz.impl;

import com.bsehk.business.dao.mapper.ExerciseFieldRelationMapper;
import com.bsehk.business.domain.ExerciseFieldRelation;
import com.bsehk.business.service.ExerciseFieldRelationService;
import lombok.Data;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

/**
 * Created by 24398 on 2018/10/20.
 */

@Service
@Data
public class ExerciseFieldRelationServiceImpl implements ExerciseFieldRelationService {

    @Resource
    private ExerciseFieldRelationMapper exerciseFieldRelationMapper;



    @Override
    public List<ExerciseFieldRelation> listByExerciseIds(List<Long> exerciseIds, Boolean isDeleted) {
        if(exerciseIds == null || exerciseIds.isEmpty()){
            return Collections.emptyList();
        }
        List<ExerciseFieldRelation> exerciseFieldRelations = this.exerciseFieldRelationMapper.listByExerciseIds(exerciseIds,isDeleted);

        return exerciseFieldRelations;
    }
}
