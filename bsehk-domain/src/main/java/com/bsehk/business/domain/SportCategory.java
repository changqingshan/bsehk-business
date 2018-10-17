package com.bsehk.business.domain;

import lombok.Data;

import java.util.Date;
@Data
public class SportCategory {
    private Long id;

    private String sportName;

    private Long parentId;

    private Date gmtCreate;

    private Date gmtModified;

    private Byte isDelete;


}