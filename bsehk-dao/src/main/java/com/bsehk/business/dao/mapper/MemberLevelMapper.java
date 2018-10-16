package com.bsehk.business.dao.mapper;

import com.bsehk.business.domain.MemberLevel;

public interface MemberLevelMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MemberLevel record);

    int insertSelective(MemberLevel record);

    MemberLevel selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MemberLevel record);

    int updateByPrimaryKey(MemberLevel record);
}