package com.bsehk.business.domain;

import lombok.Builder;
import lombok.Data;

import java.util.Date;
@Data
@Builder
public class    Brand {
    private Long id;

    private String brandName;

    private String intro;

    private String url;

    private Date gmtCreate;

    private Date gmtModified;

    private Byte isDelete;


}