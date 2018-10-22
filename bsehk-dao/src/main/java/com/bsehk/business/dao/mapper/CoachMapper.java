package com.bsehk.business.dao.mapper;

import com.bsehk.business.domain.Coach;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.apache.ibatis.annotations.Param;

import java.util.List;

import java.util.List;

public interface CoachMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Coach record);

    int insertSelective(Coach record);

    Coach selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Coach record);

    int updateByPrimaryKey(Coach record);


    List<Coach> listByIds(@Param("list") List<Long> coachIds,@Param("isDeleted") Boolean isDeleted);

    List<Coach> selectCoachByCoachId(List<Long> coachIdList);

}