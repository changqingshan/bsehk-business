package com.bsehk.business.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class CardDiscountInfo {
    private Long id;

    private Long ticketId;

    private Long memberLevelId;

    private Long roundId;

    private BigDecimal discount;

    private Date gmtCreate;

    private Date gmtModified;

    private Integer isDelete;

}