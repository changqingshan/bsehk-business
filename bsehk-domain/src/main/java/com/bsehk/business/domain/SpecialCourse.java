package com.bsehk.business.domain;

import lombok.Data;

import java.util.Date;

@Data
public class SpecialCourse {
    private Long id;

    private String title;

    private Date publishTime;

    private Date expireTime;

    private Byte isDelete;

    private Long venueId;

    private String intro;

}