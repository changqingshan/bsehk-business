package com.bsehk.business.domain;

import lombok.Data;

import java.util.Date;
@Data
public class TicketVenue {
    private Long id;

    private Long ticketId;

    private Long venueId;

    private Date gmtCreate;

    private Date gmtModified;

    private Integer isDelete;


}