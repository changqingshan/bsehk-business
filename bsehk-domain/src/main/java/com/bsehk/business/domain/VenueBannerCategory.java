package com.bsehk.business.domain;

import lombok.Data;

import java.util.Date;
@Data
public class VenueBannerCategory {
    private Long id;

    private String categoryName;

    private Date gmtCreate;

    private Date gmtModified;

    private Byte isDelete;

    private Long venueId;


}