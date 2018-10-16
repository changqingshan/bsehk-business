package com.bsehk.business.domain;

import java.math.BigDecimal;
import java.util.Date;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCardId() {
        return cardId;
    }

    public void setCardId(Long cardId) {
        this.cardId = cardId;
    }

    public Integer getChargeTimes() {
        return chargeTimes;
    }

    public void setChargeTimes(Integer chargeTimes) {
        this.chargeTimes = chargeTimes;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Integer getExtendTime() {
        return extendTime;
    }

    public void setExtendTime(Integer extendTime) {
        this.extendTime = extendTime;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
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