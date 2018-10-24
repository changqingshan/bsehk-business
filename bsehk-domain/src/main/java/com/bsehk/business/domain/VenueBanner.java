package com.bsehk.business.domain;

import lombok.Data;

import java.util.Date;
@Data
public class VenueBanner {
    private Long id;

    private Long venueId;


    private Long venueBannerCategoryId;

    private Long fileSize;

    private String url;

    private String remark;

    private Date gmtCreate;

    private Date gmtModified;

    private Byte isDelete;


}