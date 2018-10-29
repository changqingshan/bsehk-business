package com.bsehk.business.domain;

import lombok.Data;

import java.util.Date;
@Data
public class WxUserInfo {
    private Long id;

    private String openid;

    private Integer subscribe;

    private Date subscribeTime;

    private String nickname;

    private Integer sex;

    private String country;

    private String province;

    private String city;

    private String wxLanguage;

    private String headimgurl;

    private Date gmtCreate;

    private Date gmtModified;

    private Byte isDelete;

    private Long lastLocationCityId;


}