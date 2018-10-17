package com.bsehk.business.dao.mapper;


import com.bsehk.business.domain.Round;

public interface RoundMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Round record);

    int insertSelective(Round record);

    Round selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Round record);

    int updateByPrimaryKey(Round record);
}