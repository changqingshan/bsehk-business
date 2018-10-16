package com.bsehk.business.dao.mapper;

import com.bsehk.business.domain.Infrastructure;

public interface InfrastructureMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Infrastructure record);

    int insertSelective(Infrastructure record);

    Infrastructure selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Infrastructure record);

    int updateByPrimaryKeyWithBLOBs(Infrastructure record);

    int updateByPrimaryKey(Infrastructure record);
}