package com.bsehk.business.domain;

import lombok.Data;

import java.util.Date;
@Data
public class SportCategoryDisplay {
    private Long id;

    private Long sportCategoryId;

    private Date gmtCreate;

    private Date gmtModified;

    private Byte isDelete;

}