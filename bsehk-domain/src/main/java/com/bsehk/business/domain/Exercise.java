package com.bsehk.business.domain;

import lombok.Data;

import java.util.Date;
@Data
public class Exercise {
    private Long id;

    private Long coachId;

    private Long venueId;

    private String exerciseName;

    private Byte week;

    private Date exerciseStart;

    private Date exercieseEnd;

    private Date gmtCreate;

    private Date gmtModified;

    private Byte isDelete;

}