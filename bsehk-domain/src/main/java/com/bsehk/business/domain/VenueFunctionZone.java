package com.bsehk.business.domain;

import java.util.Date;

public class VenueFunctionZone {
    private Long id;

    private Long functionZoneId;

    private Long venueId;

    private String logo;

    private Date gmtCreate;

    private Date gmtModified;

    private Byte isDelete;

    private Integer functionZoneNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFunctionZoneId() {
        return functionZoneId;
    }

    public void setFunctionZoneId(Long functionZoneId) {
        this.functionZoneId = functionZoneId;
    }

    public Long getVenueId() {
        return venueId;
    }

    public void setVenueId(Long venueId) {
        this.venueId = venueId;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
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

    public Integer getFunctionZoneNumber() {
        return functionZoneNumber;
    }

    public void setFunctionZoneNumber(Integer functionZoneNumber) {
        this.functionZoneNumber = functionZoneNumber;
    }
}