package com.bsehk.business.domain;

import lombok.Data;

import java.util.Date;
@Data
public class FunctionZone {
    private Long id;

    private String functionZoneName;

    private Byte isPublic;

    private String remark;

    private Date gmtCreate;

    private Date gmtModified;

    private Byte isDelete;

}