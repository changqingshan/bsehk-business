package com.bsehk.business.domain;

import lombok.Data;

import java.util.Date;
@Data
public class ProductionGroupRelation {
    private Long id;

    private Long venueProductionGroupId;

    private Long productionId;

    private Date gmtCreate;

    private Date gmtModified;

    private Byte isDelete;

}