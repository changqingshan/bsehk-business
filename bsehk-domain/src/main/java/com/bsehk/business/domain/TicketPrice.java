package com.bsehk.business.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
@Data
public class TicketPrice {
    private Long id;

    private Long ticketId;

    private Long roundId;

    private BigDecimal weekPrice;

    private BigDecimal weekPay;

    private BigDecimal weekAccount;

    private BigDecimal holidayPrice;

    private BigDecimal holidayPay;

    private BigDecimal holidayAccount;

    private Date gmtCreate;

    private Date gmtModified;

    private Integer isDelete;


}