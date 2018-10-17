package com.bsehk.business.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
@Data
public class Ticket {
    private Long id;

    private Long sportCategoryId;

    private String ticketName;

    private Long ticketTypeId;

    private Date publishTime;

    private Date expireTime;

    private Integer validDate;

    private Integer priority;

    private Integer discountType;

    private BigDecimal discountRatio;

    private Long refundRuleId;

    private Integer isSaleOnlineWx;

    private Integer wxTotal;

    private Integer wxSingle;

    private Integer autoTerminal;

    private Integer autoTerminalTotal;

    private Integer autoTerminalSingle;

    private Integer handheldTerminal;

    private Integer handheldTerminalTotal;

    private Integer handheldTerminalSingle;

    private Integer freeTime;

    private String payUnit;

    private BigDecimal timeoutPrice;

    private Date gmtCreate;

    private Date gmtModified;

    private Integer isDelete;


}