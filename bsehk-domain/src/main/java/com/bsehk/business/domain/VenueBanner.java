package com.bsehk.business.domain;

import lombok.Data;

import java.util.Date;
@Data
public class VenueBanner {
    private Long id;

    private Long venueId;

    private String type;

    private Long size;

    private String url;

    private String remark;

    private Date gmtCreate;

    private Date gmtModified;

    private Byte isDelete;

}