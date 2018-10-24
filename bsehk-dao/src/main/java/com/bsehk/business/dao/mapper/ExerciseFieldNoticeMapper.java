package com.bsehk.business.dao.mapper;

import com.bsehk.business.domain.ExerciseFieldNotice;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface ExerciseFieldNoticeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ExerciseFieldNotice record);

    int insertSelective(ExerciseFieldNotice record);

    ExerciseFieldNotice selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ExerciseFieldNotice record);

    int updateByPrimaryKeyWithBLOBs(ExerciseFieldNotice record);

    int updateByPrimaryKey(ExerciseFieldNotice record);

    List<ExerciseFieldNotice> listByExerciseFieldIds(@Param("list") List<Long> exerciseFieldIds, @Param("date") Date date, @Param("isDelete") Boolean isDelete);
}