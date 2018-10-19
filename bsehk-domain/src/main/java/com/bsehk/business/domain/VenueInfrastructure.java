package com.bsehk.business.domain;

import lombok.Data;

import java.util.Date;
@Data
public class VenueInfrastructure {
    private Long id;

    private Long venueId;

    private Long infrastructrueId;

    private Date gmtCreate;

    private Date gmtModified;

    private Byte isDelete;

}