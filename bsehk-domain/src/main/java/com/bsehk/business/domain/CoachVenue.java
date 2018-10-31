package com.bsehk.business.domain;

import lombok.Data;

import java.util.Date;
@Data
public class CoachVenue {
    private Long id;

    private Long coachId;

    private Long venueId;

    private Date gmtCreate;

    private Date gmtModified;

    private Byte isDelete;

}