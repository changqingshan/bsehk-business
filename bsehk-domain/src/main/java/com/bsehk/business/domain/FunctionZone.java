package com.bsehk.business.domain;

import lombok.Data;

import java.util.Date;
@Data
public class FunctionZone {
    private Long id;

    private String logo;

    private String typeName;

    private String remark;

    private Date gmtCreate;

    private Date gmtModified;

    private Byte isDelete;

}