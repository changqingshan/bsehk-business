package com.bsehk.business.domain;

import java.math.BigDecimal;
import java.util.Date;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCardType() {
        return cardType;
    }

    public void setCardType(Integer cardType) {
        this.cardType = cardType;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public Integer getIsGiftCard() {
        return isGiftCard;
    }

    public void setIsGiftCard(Integer isGiftCard) {
        this.isGiftCard = isGiftCard;
    }

    public Date getSaleStart() {
        return saleStart;
    }

    public void setSaleStart(Date saleStart) {
        this.saleStart = saleStart;
    }

    public Date getSaleEnd() {
        return saleEnd;
    }

    public void setSaleEnd(Date saleEnd) {
        this.saleEnd = saleEnd;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Integer getTimes() {
        return times;
    }

    public void setTimes(Integer times) {
        this.times = times;
    }

    public Integer getValidType() {
        return validType;
    }

    public void setValidType(Integer validType) {
        this.validType = validType;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Date getPeriodStart() {
        return periodStart;
    }

    public void setPeriodStart(Date periodStart) {
        this.periodStart = periodStart;
    }

    public Date getPeriodEnd() {
        return periodEnd;
    }

    public void setPeriodEnd(Date periodEnd) {
        this.periodEnd = periodEnd;
    }

    public Long getMemberLevelId() {
        return memberLevelId;
    }

    public void setMemberLevelId(Long memberLevelId) {
        this.memberLevelId = memberLevelId;
    }

    public Date getUsageStart() {
        return usageStart;
    }

    public void setUsageStart(Date usageStart) {
        this.usageStart = usageStart;
    }

    public Date getUsageEnd() {
        return usageEnd;
    }

    public void setUsageEnd(Date usageEnd) {
        this.usageEnd = usageEnd;
    }

    public Integer getAllowGate() {
        return allowGate;
    }

    public void setAllowGate(Integer allowGate) {
        this.allowGate = allowGate;
    }

    public Integer getAutoActivate() {
        return autoActivate;
    }

    public void setAutoActivate(Integer autoActivate) {
        this.autoActivate = autoActivate;
    }

    public Integer getActivateInterval() {
        return activateInterval;
    }

    public void setActivateInterval(Integer activateInterval) {
        this.activateInterval = activateInterval;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public BigDecimal getContinuePrice() {
        return continuePrice;
    }

    public void setContinuePrice(BigDecimal continuePrice) {
        this.continuePrice = continuePrice;
    }

    public Integer getEntryNumber() {
        return entryNumber;
    }

    public void setEntryNumber(Integer entryNumber) {
        this.entryNumber = entryNumber;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public Integer getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Integer entryTime) {
        this.entryTime = entryTime;
    }

    public Integer getFreeTime() {
        return freeTime;
    }

    public void setFreeTime(Integer freeTime) {
        this.freeTime = freeTime;
    }

    public Integer getTimeoutPrice() {
        return timeoutPrice;
    }

    public void setTimeoutPrice(Integer timeoutPrice) {
        this.timeoutPrice = timeoutPrice;
    }

    public String getPayUnit() {
        return payUnit;
    }

    public void setPayUnit(String payUnit) {
        this.payUnit = payUnit;
    }

    public Integer getSaleLowNumber() {
        return saleLowNumber;
    }

    public void setSaleLowNumber(Integer saleLowNumber) {
        this.saleLowNumber = saleLowNumber;
    }

    public Integer getSaleHignNumber() {
        return saleHignNumber;
    }

    public void setSaleHignNumber(Integer saleHignNumber) {
        this.saleHignNumber = saleHignNumber;
    }

    public Integer getSaleWx() {
        return saleWx;
    }

    public void setSaleWx(Integer saleWx) {
        this.saleWx = saleWx;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }
}