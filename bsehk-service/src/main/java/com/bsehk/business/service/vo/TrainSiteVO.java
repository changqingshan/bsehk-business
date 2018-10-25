package com.bsehk.business.service.vo;

import lombok.Builder;
import lombok.Data;

/**
 * Created by 24398 on 2018/10/24.
 */
@Data
@Builder
public class TrainSiteVO {
    private Long trainSiteId;
    private String trainVenueName;
    private String siteLocation;

}
