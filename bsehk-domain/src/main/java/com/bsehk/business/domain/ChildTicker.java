package com.bsehk.business.domain;

import lombok.Data;

import java.util.Date;
@Data
public class ChildTicker {
    private Long id;

    private Long seasonTicketId;

    private Long venueId;

    private Long ticketId;

    private Integer number;

    private Date gmtCreate;

    private Date gmtModified;

    private Integer isDelete;

}