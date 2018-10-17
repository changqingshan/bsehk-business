package com.bsehk.business.domain;

import lombok.Data;

import java.util.Date;
@Data
public class VenueServiceSite {
    private Long id;

    private Long venueId;

    private String name;

    private String remark;

    private Date gmtCreate;

    private Date gmtModified;

    private Integer isDelete;

}