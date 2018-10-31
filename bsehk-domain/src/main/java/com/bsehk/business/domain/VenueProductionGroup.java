package com.bsehk.business.domain;

import lombok.Data;

import java.util.Date;
@Data
public class VenueProductionGroup {
    private Long id;

    private Long venueId;

    private String groupName;

    private Date gmtCreate;

    private Date gmtModified;

    private Byte isDelete;

    private Byte isDefault;

}