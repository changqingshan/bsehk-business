package com.bsehk.business.domain;

import lombok.Data;

import java.util.Date;
@Data
public class Operation {
    private Long id;

    private String typeName;

    private Date gmtCreate;

    private Date gmtModified;

    private Byte isDelete;

}