package com.bsehk.business.service.vo;

import com.bsehk.business.domain.Brand;
import com.bsehk.business.domain.VenueInfrastructureInfo;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class VenueInfoVo {
    private Long venueId;

    private List<VenueInfrastructureInfo> infrastructuresList;//场馆基础设施

    private List<VenueFunctionZoneVO>  FunctionZoneList;//场馆功能区

    private Brand brand;                           //场馆品牌介绍

    private String startWeek;

    private String endWeek;

    private String openTime;

    private String endTime;


}
