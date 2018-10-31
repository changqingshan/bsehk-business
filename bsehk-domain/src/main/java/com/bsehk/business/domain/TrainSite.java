package com.bsehk.business.domain;

import lombok.Data;

import java.util.Date;
@Data
public class TrainSite {
    private Long id;

    private Long venueId;

    private Long trainVenueId;

    private Date gmtCreate;

    private Date gmtModified;

    private Byte isDelete;

}