package com.bsehk.business.domain;

import lombok.Data;

import java.util.Date;
@Data
public class CoachMedia {
    private Long id;

    private Long coachId;

    private Integer mediaType;

    private String title;

    private String url;

    private Date gmtCreate;

    private Date gmtModified;

    private Byte isDelete;

}