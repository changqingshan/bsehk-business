package com.bsehk.business.domain;

import lombok.Data;

import java.util.Date;
@Data
public class CardUsage {
    private Long id;

    private Long cardId;

    private Integer week;

    private Date gmtCreate;

    private Date gmtModified;

    private Byte isDelete;

}