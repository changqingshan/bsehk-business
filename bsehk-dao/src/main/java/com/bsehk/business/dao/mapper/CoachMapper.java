package com.bsehk.business.dao.mapper;

import com.bsehk.business.domain.Coach;
import org.apache.ibatis.annotations.Param;

import java.util.List;

import java.util.List;

public interface CoachMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Coach record);

    int insertSelective(Coach record);

    Coach selectByPrimaryKey(Long id);

    List<Coach> selectAllCoach();

    int updateByPrimaryKeySelective(Coach record);

    int updateByPrimaryKey(Coach record);


    List<Coach> listByIds(@Param("list") List<Long> coachIds);

    List<Coach> selectCoachByCoachId(List<Long> coachIdList);

}