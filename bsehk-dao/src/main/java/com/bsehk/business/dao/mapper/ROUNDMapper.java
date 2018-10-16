package com.bsehk.business.dao.mapper;

import com.bsehk.business.domain.ROUND;

public interface ROUNDMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ROUND record);

    int insertSelective(ROUND record);

    ROUND selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ROUND record);

    int updateByPrimaryKey(ROUND record);
}