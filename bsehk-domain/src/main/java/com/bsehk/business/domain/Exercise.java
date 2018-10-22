package com.bsehk.business.domain;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class Exercise {
    private Long id;

    private Long venueId;

    private String exerciseName;

    private Byte week;

    private Date exerciseStart;

    private Date exerciseEnd;

    private Date gmtCreate;

    private Date gmtModified;

    private Byte isDelete;


}