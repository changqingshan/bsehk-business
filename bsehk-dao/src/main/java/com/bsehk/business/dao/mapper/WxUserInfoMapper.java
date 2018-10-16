package com.bsehk.business.dao.mapper;

import com.bsehk.business.domain.WxUserInfo;

public interface WxUserInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(WxUserInfo record);

    int insertSelective(WxUserInfo record);

    WxUserInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(WxUserInfo record);

    int updateByPrimaryKey(WxUserInfo record);
}