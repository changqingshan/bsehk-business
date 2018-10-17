package com.bsehk.business.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
@Data
public class ValueCardChargeRule {
    private Long id;

    private Long cardId;

    private Integer cardDiscountType;

    private BigDecimal amount;

    private BigDecimal giftAmounte;

    private Date gmtCreate;

    private Date gmtModified;

    private Byte isDelete;


}