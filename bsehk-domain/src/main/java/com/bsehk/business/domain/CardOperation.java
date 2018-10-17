package com.bsehk.business.domain;

import lombok.Data;

import java.util.Date;
@Data
public class CardOperation {
    private Long id;

    private Long cardId;

    private Long operationId;

    private Date gmtCreate;

    private Date gmtModified;

    private Integer isDelete;

}