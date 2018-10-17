package com.bsehk.business.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Brand {
    private Long id;

    private String intro;

    private String url;

    private Date gmtCreate;

    private Date gmtModified;

    private Byte isDelete;

}