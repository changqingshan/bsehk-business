package com.bsehk.business.domain;

import lombok.Data;

import java.util.Date;
@Data
public class VenueNotice {
    private Long id;

    private Long venueId;

    private String title;

    private String content;

    private Date publishTime;

    private Date expireTime;

    private Date gmtCreate;

    private Date gmtModified;

    private Byte isDelete;


}