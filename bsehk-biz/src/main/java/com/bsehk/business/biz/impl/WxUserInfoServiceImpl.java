package com.bsehk.business.biz.impl;

import com.bsehk.business.dao.mapper.WxUserInfoMapper;
import com.bsehk.business.domain.WxUserInfo;
import com.bsehk.business.service.WxUserInfoService;
import com.bsehk.common.exception.BizException;
import com.bsehk.common.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class WxUserInfoServiceImpl implements WxUserInfoService {

    @Resource
    private WxUserInfoMapper wxUserInfoMapper;

    @Override
    public WxUserInfo selectByOpenid(String openid,Boolean isDelete) {
        if(StringUtil.isBlank(openid)){
            return null;
        }
        WxUserInfo wxUserInfo = this.wxUserInfoMapper.selectByOpenid(openid,isDelete);

        return wxUserInfo;
    }

    @Override
    public void saveLastLocationCity(String openid, Long cityId) {
        int n = this.wxUserInfoMapper.saveLastLocationCity(openid,cityId,false);
        if(n  == 0){
            throw new BizException("保存切换城市失败");
        }
    }
}
