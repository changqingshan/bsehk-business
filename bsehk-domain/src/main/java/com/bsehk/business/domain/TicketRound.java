package com.bsehk.business.domain;

import lombok.Data;

import java.util.Date;
@Data
public class TicketRound {
    private Long id;

    private Long ticketId;

    private Long roundId;

    private Date gmtCreate;

    private Date gmtModified;

    private Integer isDelete;


}