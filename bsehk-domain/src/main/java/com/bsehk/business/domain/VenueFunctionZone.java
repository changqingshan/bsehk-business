package com.bsehk.business.domain;

import lombok.Data;

import java.util.Date;


@Data
public class VenueFunctionZone {
    private Long id;

    private Long functionZoneId;

    private Long venueId;

    private Date gmtCreate;

    private Date gmtModified;

    private Byte isDelete;

    private Integer functionZoneNumber;


}