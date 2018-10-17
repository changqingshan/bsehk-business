package com.bsehk.business.domain;

import lombok.Data;

import java.util.Date;
@Data
public class TicketSaleTime {
    private Long id;

    private Long ticketId;

    private Date saleStart;

    private Date saleStop;

    private Date gmtCreate;

    private Date gmtModified;

    private Integer isDelete;


}