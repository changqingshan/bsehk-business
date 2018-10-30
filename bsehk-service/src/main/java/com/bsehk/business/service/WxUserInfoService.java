package com.bsehk.business.service;

import com.bsehk.business.domain.WxUserInfo;

public interface WxUserInfoService {
    WxUserInfo selectByOpenid(String openid,Boolean isDelete);

    void saveLastLocationCity(String openid, Long cityId);
}
