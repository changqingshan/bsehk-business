package com.bsehk.business.domain;

import lombok.Data;

import java.util.Date;
@Data
public class BusinessType {
    private Long id;

    private String typeDesc;

    private Date gmtCreate;

    private Date gmtModified;

    private Byte isDelete;


}