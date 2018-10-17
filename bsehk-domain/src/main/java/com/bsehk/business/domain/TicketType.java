package com.bsehk.business.domain;

import lombok.Data;

import java.util.Date;
@Data
public class TicketType {
    private Long id;

    private String typeName;

    private Long parentId;

    private Date gmtCreate;

    private Date gmtModified;

    private Integer isDelete;


}