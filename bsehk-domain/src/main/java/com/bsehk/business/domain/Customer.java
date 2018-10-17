package com.bsehk.business.domain;

import lombok.Data;

import java.util.Date;
@Data
public class Customer {
    private Long id;

    private Long wxUserInfoId;

    private String accountNo;

    private Integer isMember;

    private String cardNo;

    private Integer identityType;

    private String identityUrl;

    private String identityNo;

    private String name;

    private Integer gender;

    private Date birth;

    private String location;

    private Date expireTime;

    private String phone;

    private String fixedLineNumber;

    private String company;

    private String emergencyName;

    private String emergencyMobile;

    private Long relationshipId;

    private String emergencyLocation;

    private String remark;

    private Date gmtCreate;

    private Date gmtModified;

    private Byte isDelete;

}