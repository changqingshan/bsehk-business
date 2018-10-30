package com.bsehk.business.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
@Data
public class Production {
    private Long id;

    private Byte productionType;

    private String productionName;

    private String productionUrl;

    private String productionIntro;

    private Date gmtCreate;

    private Date gmtModified;

    private Byte isDelete;

    private Long venueId;

    private BigDecimal productionPrice;

    private Byte onShelf;


}