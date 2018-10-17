package com.bsehk.business.domain;

import lombok.Data;

import java.util.Date;
@Data
public class RefundRule {
    private Long id;

    private String name;

    private String ruleDesc;

    private Date gmtCreate;

    private Date gmtModified;

    private Integer isDelete;

}