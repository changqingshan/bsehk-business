package com.bsehk.business.domain;

import lombok.Data;

import java.util.Date;
@Data
public class ExerciseField {
    private Long id;

    private Long venueId;

    private String field;

    private Date gmtCreate;

    private Date gmtModified;

    private Byte isDelete;

}