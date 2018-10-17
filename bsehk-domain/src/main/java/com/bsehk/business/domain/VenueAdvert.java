package com.bsehk.business.domain;

import lombok.Data;

import java.util.Date;
@Data
public class VenueAdvert {
    private Long id;

    private String content;

    private String url;

    private Date startTime;

    private Date endTime;

    private Date gmtCreate;

    private Date gmtModified;

    private Byte isDelete;


}