package com.bsehk.business.domain;

import lombok.Data;

/**
 * Created by 24398 on 2018/10/24.
 */
@Data
public class TrainSiteInfo {
    private Long id;
    private Long trainVenueId;
    private String trainVenueName;
    private Long provinceId;
    private Long cityId;
    private Long districtId;
    private String detailLocation;

}
