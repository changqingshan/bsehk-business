package com.bsehk.business.dao.mapper;

import com.bsehk.business.domain.Relationship;

public interface RelationshipMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Relationship record);

    int insertSelective(Relationship record);

    Relationship selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Relationship record);

    int updateByPrimaryKey(Relationship record);
}