package com.bsehk.business.domain;

import java.math.BigDecimal;
import java.util.Date;

public class SaleDiscountRule {
    private Long id;

    private Long cardId;

    private Integer cardDiscountType;

    private Integer discountLimit;

    private BigDecimal discount;

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

    public Integer getDiscountLimit() {
        return discountLimit;
    }

    public void setDiscountLimit(Integer discountLimit) {
        this.discountLimit = discountLimit;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
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