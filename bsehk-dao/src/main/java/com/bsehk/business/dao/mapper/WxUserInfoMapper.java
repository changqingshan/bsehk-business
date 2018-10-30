package com.bsehk.business.dao.mapper;

import com.bsehk.business.domain.WxUserInfo;
import org.apache.ibatis.annotations.Param;

public interface WxUserInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(WxUserInfo record);

    int insertSelective(WxUserInfo record);

    WxUserInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(WxUserInfo record);

    int updateByPrimaryKey(WxUserInfo record);

    WxUserInfo selectByOpenid(@Param("openid") String openid,@Param("isDelete") Boolean isDelete);

    Integer saveLastLocationCity(@Param("openid") String openid, @Param("lastLocationCityId") Long lastLocationCityId,@Param("isDelete") Boolean isDelete);
}