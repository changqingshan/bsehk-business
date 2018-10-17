package com.bsehk.business.domain;

import lombok.Data;

import java.util.Date;

@Data
public class CardBusiness {
    private Long id;

    private Long cardId;

    private Long vnueuId;

    private Long businessTypeId;

    private Date gmtCreate;

    private Date gmtModified;

    private Byte isDelete;

}