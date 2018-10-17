package com.bsehk.business.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
@Data
public class TimeCardChargeRule {
    private Long id;

    private Long cardId;

    private Integer chargeTimes;

    private BigDecimal amount;

    private Integer extendTime;

    private String unit;

    private Date gmtCreate;

    private Date gmtModified;

    private Byte isDelete;


}