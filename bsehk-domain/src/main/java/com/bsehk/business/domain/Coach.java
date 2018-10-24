package com.bsehk.business.domain;

import lombok.Data;

import java.util.Date;
@Data
public class Coach {
    private Long id;

    private Byte coachType;

    private String coachName;

    private String title;

    private String intro;

    private Integer gender;

    private String phone;

    private String identityNo;

    private Integer isPersonal;

    private Date gmtCreate;

    private Date gmtModified;

    private Byte isDelete;

    private String appearanceUrl;

}