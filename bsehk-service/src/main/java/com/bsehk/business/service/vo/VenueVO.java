package com.bsehk.business.service.vo;

import com.bsehk.business.domain.*;
import lombok.Builder;
import lombok.Data;

import java.sql.Time;
import java.util.Date;
import java.util.List;
@Data
@Builder
public class VenueVO {
    private Long venueId;

    private String venueName;

    private String detailLocation;      //详细地址

    private String mobile;

    private Byte startWeek;

    private Byte endWeek;

    private Date openTime;

    private Date endTime;

    private List<VenueSport> venueSportList;       //场馆运动小类

    private List<VenueInfrastructureInfo> infrastructuresList;//场馆基础信息

    //private List<FunctionZone>  functionZoneList;//功能区集合
}
