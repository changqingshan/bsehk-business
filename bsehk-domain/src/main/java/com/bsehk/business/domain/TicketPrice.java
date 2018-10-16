package com.bsehk.business.domain;

import java.math.BigDecimal;
import java.util.Date;

public class TicketPrice {
    private Long id;

    private Long ticketId;

    private Long roundId;

    private BigDecimal weekPrice;

    private BigDecimal weekPay;

    private BigDecimal weekAccount;

    private BigDecimal holidayPrice;

    private BigDecimal holidayPay;

    private BigDecimal holidayAccount;

    private Date gmtCreate;

    private Date gmtModified;

    private Integer isDelete;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    public Long getRoundId() {
        return roundId;
    }

    public void setRoundId(Long roundId) {
        this.roundId = roundId;
    }

    public BigDecimal getWeekPrice() {
        return weekPrice;
    }

    public void setWeekPrice(BigDecimal weekPrice) {
        this.weekPrice = weekPrice;
    }

    public BigDecimal getWeekPay() {
        return weekPay;
    }

    public void setWeekPay(BigDecimal weekPay) {
        this.weekPay = weekPay;
    }

    public BigDecimal getWeekAccount() {
        return weekAccount;
    }

    public void setWeekAccount(BigDecimal weekAccount) {
        this.weekAccount = weekAccount;
    }

    public BigDecimal getHolidayPrice() {
        return holidayPrice;
    }

    public void setHolidayPrice(BigDecimal holidayPrice) {
        this.holidayPrice = holidayPrice;
    }

    public BigDecimal getHolidayPay() {
        return holidayPay;
    }

    public void setHolidayPay(BigDecimal holidayPay) {
        this.holidayPay = holidayPay;
    }

    public BigDecimal getHolidayAccount() {
        return holidayAccount;
    }

    public void setHolidayAccount(BigDecimal holidayAccount) {
        this.holidayAccount = holidayAccount;
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