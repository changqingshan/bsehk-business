package com.bsehk.business.dao.mapper;

import com.bsehk.business.domain.CustomerMemberLevel;

public interface CustomerMemberLevelMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CustomerMemberLevel record);

    int insertSelective(CustomerMemberLevel record);

    CustomerMemberLevel selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CustomerMemberLevel record);

    int updateByPrimaryKey(CustomerMemberLevel record);
}