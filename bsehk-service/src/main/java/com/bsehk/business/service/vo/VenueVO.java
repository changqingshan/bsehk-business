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

    private List<VenueBannerVO> venueBannerVOS;     //场馆banner

    private VenueNotice venueNotice;               //场馆公告

    private VenueAdvert venueAdvert;               //场馆广告

    private Brand brand;                           //场馆品牌介绍
}
