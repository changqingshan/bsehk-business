package com.bsehk.business.dao.mapper;

import com.bsehk.business.domain.Operation;

public interface OperationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Operation record);

    int insertSelective(Operation record);

    Operation selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Operation record);

    int updateByPrimaryKey(Operation record);
}