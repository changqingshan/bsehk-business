package com.bsehk.business.domain;

import lombok.Data;

import java.util.Date;
@Data
public class ExerciseFieldRelation {
    private Long id;

    private Long exerciseId;

    private Long exerciseFieldId;

    private Long coachId;

    private Date gmtCreate;

    private Date gmtModified;

    private Byte isDeleted;


}