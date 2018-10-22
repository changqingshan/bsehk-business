package com.bsehk.business.service.vo;

import com.bsehk.business.domain.Brand;
import com.bsehk.business.domain.VenueFunctionZoneInfo;
import com.bsehk.business.domain.VenueInfrastructureInfo;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;
@Data
@Builder
public class VenueInfoVo {
    private Long venueId;

    private List<VenueInfrastructureInfo> infrastructuresList;//场馆基础设施

    private List<VenueFunctionZoneInfo> functionZoneInfoList;//场馆功能区

    private Brand brand;                           //场馆品牌介绍

    private String intro;                        //场馆简介

    private Byte startWeek;

    private Byte endWeek;

    private Date openTime;

    private Date endTime;
}
