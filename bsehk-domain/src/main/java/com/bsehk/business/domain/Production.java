package com.bsehk.business.domain;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
@Data
@Builder

public class Production {
    private Long id;

    private Long venueId;

    private Byte productionType;

    private String productionName;

    private String productionUrl;

    private String productionIntro;

    private BigDecimal productionPrice;

    private Date gmtCreate;

    private Date gmtModified;

    private Byte isDelete;
}