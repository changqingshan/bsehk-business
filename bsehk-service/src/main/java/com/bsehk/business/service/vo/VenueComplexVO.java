package com.bsehk.business.service.vo;

import com.bsehk.business.domain.*;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;
@Data
@Builder
public class VenueComplexVO {
    private Long venueId;

    private String venueName;

    private String detailLocation;      //详细地址

    private String mobile;

    private Byte startWeek;
 //   @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Byte endWeek;
//    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private String openTime;

    private String endTime;
    private String url;           //场馆形象图

    private List<VenueSport> venueSportList;       //场馆运动小类

    private List<VenueInfrastructureInfo> infrastructuresList;//场馆基础信息

    private Integer bannerNumber;                   //场馆banner数量

    private VenueNotice venueNotice;               //场馆公告

    private VenueAdvert venueAdvert;               //场馆广告

    private Brand brand;                           //场馆品牌介绍
}