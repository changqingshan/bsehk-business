package com.bsehk.business.domain;

import lombok.Data;

import java.util.Date;
@Data
public class MerchantCompany {
    private Long id;

    private String companyName;

    private String mobile;

    private Date gmtCreate;

    private Date gmtModified;

    private Byte isDelete;

}