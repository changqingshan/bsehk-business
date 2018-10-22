package com.bsehk.business.dao.mapper;

import com.bsehk.business.domain.ExerciseField;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExerciseFieldMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ExerciseField record);

    int insertSelective(ExerciseField record);

    ExerciseField selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ExerciseField record);

    int updateByPrimaryKey(ExerciseField record);

    List<ExerciseField> listByIds(@Param("list") List<Long> exerciseFieldIds,@Param("isDeleted") Boolean isDeleted);
}