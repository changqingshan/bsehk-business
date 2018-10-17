package com.bsehk.business.domain;

import lombok.Data;

import java.util.Date;

@Data
public class City {
    private Long id;

    private String name;

    private Integer level;

    private Long parentId;

    private Date gmtCreate;

    private Date gmtModified;

    private Byte isDelete;


}