package com.bsehk.business.domain;

import lombok.Data;

import java.util.Date;
@Data
public class Venue {
    private Long id;

    private Long brandId;

    private String venueName;

    private Integer venueCategory;

    private Long provinceId;

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

}