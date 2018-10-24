package com.bsehk.business.domain;

import lombok.Data;

import java.util.Date;

@Data
public class ExerciseFieldNotice {
    private Long id;

    private Long exerciseFieldId;

    private String title;

    private Date publishTime;

    private Date expireTime;

    private Date gmtCreate;

    private Date gmtModified;

    private Byte isDelete;

    private String content;


}