package com.bsehk.business.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
@Data
public class MemberLevel {
    private Long id;

    private Long venueId;

    private String memberDesc;

    private Integer discountType;

    private BigDecimal discount;

    private Date gmtCreate;

    private Date gmtModified;

    private Integer isDelete;

}