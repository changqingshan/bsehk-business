package com.bsehk.business.domain;

import lombok.Data;

import java.util.Date;
@Data
public class Infrastructure {
    private Long id;

    private String infrastructureName;

    private String logo;

    private Date gmtCreate;

    private Date gmtModified;

    private Byte isDelete;

    private byte[] remark;

}