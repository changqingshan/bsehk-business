package com.bsehk.business.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class Card {
    private Long id;

    private Integer cardType;

    private String cardName;

    private Integer isGiftCard;

    private Date saleStart;

    private Date saleEnd;

    private BigDecimal amount;

    private Integer times;

    private Integer validType;

    private Integer period;

    private String unit;

    private Date periodStart;

    private Date periodEnd;

    private Long memberLevelId;

    private Date usageStart;

    private Date usageEnd;

    private Integer allowGate;

    private Integer autoActivate;

    private Integer activateInterval;

    private BigDecimal salePrice;

    private BigDecimal continuePrice;

    private Integer entryNumber;

    private BigDecimal discount;

    private Integer entryTime;

    private Integer freeTime;

    private Integer timeoutPrice;

    private String payUnit;

    private Integer saleLowNumber;

    private Integer saleHignNumber;

    private Integer saleWx;

    private String priority;

    private Date gmtCreate;

    private Date gmtModified;

    private Byte isDelete;

}