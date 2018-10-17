package com.bsehk.business.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
@Data
public class RefundRuleInfo {
    private Long id;

    private Long refundRuleId;

    private Integer ticketStatus;

    private Integer refundType;

    private BigDecimal deduction;

    private Date gmtCreate;

    private Date gmtModified;

    private Integer isDelete;

}