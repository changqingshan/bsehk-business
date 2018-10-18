package com.bsehk.business.domain;

import lombok.Data;

import java.util.Date;
@Data
public class Round {
    private Long id;

    private Long sportCategoryId;

    private String roundName;

    private Date startTime;

    private Date endTime;

    private Date gmtCreate;

    private Date gmtModified;

    private Byte isDelete;


}