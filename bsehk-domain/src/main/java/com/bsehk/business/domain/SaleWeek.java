package com.bsehk.business.domain;

import lombok.Data;

import java.util.Date;
@Data
public class SaleWeek {
    private Long id;

    private Long ticketId;

    private Integer week;

    private Date gmtCreate;

    private Date gmtModified;

    private Integer isDelete;

}