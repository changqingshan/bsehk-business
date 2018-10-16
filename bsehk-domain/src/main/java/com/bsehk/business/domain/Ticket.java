package com.bsehk.business.domain;

import java.math.BigDecimal;
import java.util.Date;

public class Ticket {
    private Long id;

    private Long sportCategoryId;

    private String ticketName;

    private Long ticketTypeId;

    private Date publishTime;

    private Date expireTime;

    private Integer validDate;

    private Integer priority;

    private Integer discountType;

    private BigDecimal discountRatio;

    private Long refundRuleId;

    private Integer isSaleOnlineWx;

    private Integer wxTotal;

    private Integer wxSingle;

    private Integer autoTerminal;

    private Integer autoTerminalTotal;

    private Integer autoTerminalSingle;

    private Integer handheldTerminal;

    private Integer handheldTerminalTotal;

    private Integer handheldTerminalSingle;

    private Integer freeTime;

    private String payUnit;

    private BigDecimal timeoutPrice;

    private Date gmtCreate;

    private Date gmtModified;

    private Integer isDelete;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSportCategoryId() {
        return sportCategoryId;
    }

    public void setSportCategoryId(Long sportCategoryId) {
        this.sportCategoryId = sportCategoryId;
    }

    public String getTicketName() {
        return ticketName;
    }

    public void setTicketName(String ticketName) {
        this.ticketName = ticketName;
    }

    public Long getTicketTypeId() {
        return ticketTypeId;
    }

    public void setTicketTypeId(Long ticketTypeId) {
        this.ticketTypeId = ticketTypeId;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    public Integer getValidDate() {
        return validDate;
    }

    public void setValidDate(Integer validDate) {
        this.validDate = validDate;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Integer getDiscountType() {
        return discountType;
    }

    public void setDiscountType(Integer discountType) {
        this.discountType = discountType;
    }

    public BigDecimal getDiscountRatio() {
        return discountRatio;
    }

    public void setDiscountRatio(BigDecimal discountRatio) {
        this.discountRatio = discountRatio;
    }

    public Long getRefundRuleId() {
        return refundRuleId;
    }

    public void setRefundRuleId(Long refundRuleId) {
        this.refundRuleId = refundRuleId;
    }

    public Integer getIsSaleOnlineWx() {
        return isSaleOnlineWx;
    }

    public void setIsSaleOnlineWx(Integer isSaleOnlineWx) {
        this.isSaleOnlineWx = isSaleOnlineWx;
    }

    public Integer getWxTotal() {
        return wxTotal;
    }

    public void setWxTotal(Integer wxTotal) {
        this.wxTotal = wxTotal;
    }

    public Integer getWxSingle() {
        return wxSingle;
    }

    public void setWxSingle(Integer wxSingle) {
        this.wxSingle = wxSingle;
    }

    public Integer getAutoTerminal() {
        return autoTerminal;
    }

    public void setAutoTerminal(Integer autoTerminal) {
        this.autoTerminal = autoTerminal;
    }

    public Integer getAutoTerminalTotal() {
        return autoTerminalTotal;
    }

    public void setAutoTerminalTotal(Integer autoTerminalTotal) {
        this.autoTerminalTotal = autoTerminalTotal;
    }

    public Integer getAutoTerminalSingle() {
        return autoTerminalSingle;
    }

    public void setAutoTerminalSingle(Integer autoTerminalSingle) {
        this.autoTerminalSingle = autoTerminalSingle;
    }

    public Integer getHandheldTerminal() {
        return handheldTerminal;
    }

    public void setHandheldTerminal(Integer handheldTerminal) {
        this.handheldTerminal = handheldTerminal;
    }

    public Integer getHandheldTerminalTotal() {
        return handheldTerminalTotal;
    }

    public void setHandheldTerminalTotal(Integer handheldTerminalTotal) {
        this.handheldTerminalTotal = handheldTerminalTotal;
    }

    public Integer getHandheldTerminalSingle() {
        return handheldTerminalSingle;
    }

    public void setHandheldTerminalSingle(Integer handheldTerminalSingle) {
        this.handheldTerminalSingle = handheldTerminalSingle;
    }

    public Integer getFreeTime() {
        return freeTime;
    }

    public void setFreeTime(Integer freeTime) {
        this.freeTime = freeTime;
    }

    public String getPayUnit() {
        return payUnit;
    }

    public void setPayUnit(String payUnit) {
        this.payUnit = payUnit;
    }

    public BigDecimal getTimeoutPrice() {
        return timeoutPrice;
    }

    public void setTimeoutPrice(BigDecimal timeoutPrice) {
        this.timeoutPrice = timeoutPrice;
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

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
}