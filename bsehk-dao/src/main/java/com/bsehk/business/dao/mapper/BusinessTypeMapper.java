package com.bsehk.business.dao.mapper;

import com.bsehk.business.domain.BusinessType;

public interface BusinessTypeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BusinessType record);

    int insertSelective(BusinessType record);

    BusinessType selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BusinessType record);

    int updateByPrimaryKey(BusinessType record);
}