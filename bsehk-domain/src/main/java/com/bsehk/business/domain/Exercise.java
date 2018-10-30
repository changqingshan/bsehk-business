package com.bsehk.business.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Exercise {
    private Long id;

    private Long venueId;

    private String exerciseName;

    private Byte week;

    private Long exerciseCourseTimeId;

    private Date gmtCreate;

    private Date gmtModified;

    private Byte isDelete;

}