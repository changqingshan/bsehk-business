package com.bsehk.business.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
@Data
public class SaleDiscountRule {
    private Long id;

    private Long cardId;

    private Integer cardDiscountType;

    private Integer discountLimit;

    private BigDecimal discount;

    private Date gmtCreate;

    private Date gmtModified;

    private Byte isDelete;

}