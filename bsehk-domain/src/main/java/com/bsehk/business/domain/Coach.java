package com.bsehk.business.domain;

import lombok.Data;

import java.util.Date;
@Data
public class Coach {
    private Long id;

    private Long venueId;

    private String name;

    private Integer gender;

    private String phone;

    private String identityNo;

    private Integer isPersonal;

    private Date gmtCreate;

    private Date gmtModified;

    private Byte isDelete;

}