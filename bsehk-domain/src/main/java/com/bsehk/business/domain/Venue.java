package com.bsehk.business.domain;

import java.util.Date;

public class Venue {
    private Long id;

    private Long brandId;

    private String venueName;

    private Integer venueCategory;

    private Long privinceId;

    private Long cityId;

    private Long districtId;

    private String detailLocation;

    private String longitude;

    private String latitude;

    private String intro;

    private String mobile;

    private Byte startWeek;

    private Byte endWeek;

    private Date openTime;

    private Date endTime;

    private Date gmtCreate;

    private Date gmtModified;

    private Byte isDelete;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public Integer getVenueCategory() {
        return venueCategory;
    }

    public void setVenueCategory(Integer venueCategory) {
        this.venueCategory = venueCategory;
    }

    public Long getPrivinceId() {
        return privinceId;
    }

    public void setPrivinceId(Long privinceId) {
        this.privinceId = privinceId;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public Long getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Long districtId) {
        this.districtId = districtId;
    }

    public String getDetailLocation() {
        return detailLocation;
    }

    public void setDetailLocation(String detailLocation) {
        this.detailLocation = detailLocation;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Byte getStartWeek() {
        return startWeek;
    }

    public void setStartWeek(Byte startWeek) {
        this.startWeek = startWeek;
    }

    public Byte getEndWeek() {
        return endWeek;
    }

    public void setEndWeek(Byte endWeek) {
        this.endWeek = endWeek;
    }

    public Date getOpenTime() {
        return openTime;
    }

    public void setOpenTime(Date openTime) {
        this.openTime = openTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
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