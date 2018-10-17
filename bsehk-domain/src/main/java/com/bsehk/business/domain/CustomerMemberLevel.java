package com.bsehk.business.domain;

import lombok.Data;

@Data
public class CustomerMemberLevel {
    private Long id;

    private Long customerId;

    private Long venueId;

    private Long memberLevelId;

    private Byte isDelete;

}