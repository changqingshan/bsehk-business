package com.bsehk.business.domain;

import lombok.Data;

import java.util.Date;
@Data
public class CardSaleServiceSite {
    private Long id;

    private Long cardId;

    private Long venueId;

    private Long serviceSiteId;

    private Date gmtCreate;

    private Date gmtModified;

    private Byte isDelete;

}