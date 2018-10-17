package com.bsehk.business.domain;

import lombok.Data;

import java.util.Date;
@Data
public class Relationship {
    private Long id;

    private String relationDesc;

    private Date gmtCreate;

    private Date gmtModified;

    private Byte isDelete;

}