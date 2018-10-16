package com.bsehk.business.domain;

import java.util.Date;

public class Infrastructure {
    private Long id;

    private String infrastructureName;

    private String logo;

    private Date gmtCreate;

    private Date gmtModified;

    private Byte isDelete;

    private byte[] remark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInfrastructureName() {
        return infrastructureName;
    }

    public void setInfrastructureName(String infrastructureName) {
        this.infrastructureName = infrastructureName;
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

    public byte[] getRemark() {
        return remark;
    }

    public void setRemark(byte[] remark) {
        this.remark = remark;
    }
}