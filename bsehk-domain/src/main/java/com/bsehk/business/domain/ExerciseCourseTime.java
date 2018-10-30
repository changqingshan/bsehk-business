package com.bsehk.business.domain;

import lombok.Data;

import java.util.Date;

@Data
public class ExerciseCourseTime {
    private Long id;

    private Long exerciseFieldId;

    private Integer ordinal;

    private Date exerciseStart;

    private Date exercieseEnd;

    private Date gmtCreate;

    private Date gmtModified;

    private Byte isDelete;

}