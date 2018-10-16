package com.bsehk.business.domain;

import java.math.BigDecimal;
import java.util.Date;

public class ValueCardChargeRule {
    private Long id;

    private Long cardId;

    private Integer cardDiscountType;

    private BigDecimal amount;

    private BigDecimal giftAmounte;

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

    public Integer getCardDiscountType() {
        return cardDiscountType;
    }

    public void setCardDiscountType(Integer cardDiscountType) {
        this.cardDiscountType = cardDiscountType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getGiftAmounte() {
        return giftAmounte;
    }

    public void setGiftAmounte(BigDecimal giftAmounte) {
        this.giftAmounte = giftAmounte;
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