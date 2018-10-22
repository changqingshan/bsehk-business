package com.bsehk.business.biz.impl;

import com.bsehk.business.dao.mapper.VenueMapper;
import com.bsehk.business.domain.*;
import com.bsehk.business.service.*;
import com.bsehk.business.service.vo.VenueBannerVO;
import com.bsehk.business.service.vo.VenueBriefVO;
import com.bsehk.business.service.vo.VenueInfoVo;
import com.bsehk.business.service.vo.VenueVO;
import com.bsehk.common.util.StringUtil;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.*;
import java.util.stream.Collectors;


@Service
@Slf4j
public class VenueServiceImpl implements VenueService {
    @Resource
    private VenueMapper venueMapper;
    @Resource
    private CityService cityService;
    @Resource
    private SportCategoryService sportCategoryService;
    @Resource
    private VenueSportCategoryService venueSportCategoryService;
    @Resource
    private VenueInfrastructureService venueInfrastructureService;
    @Resource
    private  VenueFunctionZoneService venueFunctionZoneService;
    @Resource
    VenueBannerService venueBannerService;
    @Resource
    VenueNoticeService venueNoticeService;
    @Resource
    VenueAdvertService venueAdvertService;
    @Resource
    BrandService brandService;

    @Override
    public VenueVO selectVenueById(Long venueId) {
        //获取场馆信息
        Venue venue = venueMapper.selectByPrimaryKey(venueId);
        //获取场馆所有运动类别
        List<Long> venueIds = new ArrayList<>();
        venueIds.add(venueId);
        List<VenueSport> venueSports = venueSportCategoryService.listVenueSport(venueIds);
        //筛选场馆运动类中的小类
        List<VenueSport> venueSmallSports = new ArrayList<>();
        for (int i=0;i<venueSports.size();i++){
            if(venueSports.get(i).getParentId()!=0){
                venueSmallSports.add(venueSports.get(i));
            }
        }
        //获取免费设施
        List<VenueInfrastructureInfo> venueInfrastructureInfos = venueInfrastructureService.selectVenueInfrastructureInfoByVenueId(venueId);
        //获取场馆banner图分类展示
        List<VenueBannerVO> venueBannerVOList = venueBannerService.selectBannerByVenueId(venueId);
        //获取场馆公告展示
        VenueNotice venueNotice = venueNoticeService.selectNoticeByVenueId(venueId);
        //获取场馆广告展示
        VenueAdvert venueAdvert = venueAdvertService.selectAdvertByVenueId(venueId);
        //获取场馆品牌介绍
        Brand brand = brandService.selectBrandByVenueId(venueId);
        //数据打包
        VenueVO venueVO = VenueVO.builder()
                        .venueId(venueId)
                        .venueName(venue.getVenueName())
                        .detailLocation(venue.getDetailLocation())
                        .mobile(venue.getMobile())
                        .startWeek(venue.getStartWeek())
                        .endWeek(venue.getEndWeek())
                        .openTime(venue.getOpenTime())
                        .endTime(venue.getEndTime())
                        .venueSportList(venueSmallSports)
                        .infrastructuresList(venueInfrastructureInfos)
                        .venueBannerVOS(venueBannerVOList)
                        .venueNotice(venueNotice)
                        .venueAdvert(venueAdvert)
                        .brand(brand)
                        .build();

        return venueVO;
    }




    @Override
    public List<VenueBriefVO> searchVenue(Long cityId, Long sportCategoryId, Double longitude, Double latitude, String venueName) {
        if(StringUtil.isBlank(venueName)){
           venueName = null;
        }

        List<Long> sportCategoryIds;
        if(sportCategoryId == null){
            // 选择一级页的全部运动标签或者没有选择运动标签
            sportCategoryIds = Collections.emptyList();
        }else if(  sportCategoryId > 0){
            sportCategoryIds = new ArrayList<>();
            // 判断可能是出入二级页时的运动标签
             SportCategory sportCategory = this.sportCategoryService.selectById(sportCategoryId);
             if(sportCategory != null){
                 // 是刚进入二级页面时选择的运动标签
                 List<SportCategory> sportCategories = this.sportCategoryService.listByParentId(sportCategoryId);
                 sportCategoryIds = sportCategories.parallelStream().map(SportCategory::getId).collect(Collectors.toList());
             }else{
               sportCategoryIds.add(sportCategoryId);
             }
        }else{
            // 该运动大类下所有的运动
            //为负数
            Long primarySportCategoryId = Math.abs(sportCategoryId);
            List<SportCategory> sportCategories = this.sportCategoryService.listByParentId(primarySportCategoryId);
            sportCategoryIds = sportCategories.parallelStream().map(SportCategory::getId).collect(Collectors.toList());
        }

        List<Venue> venues = this.venueMapper.searchVenue(cityId,sportCategoryIds,venueName);
        if(venues == null || venues.isEmpty()){
            return Collections.emptyList();
        }
        // 查询所有场馆的体育运动标签
        List<Long> venueIds = venues.parallelStream().map(Venue::getId).collect(Collectors.toList());
        List<VenueSport> venueSports = this.venueSportCategoryService.listVenueSport(venueIds);
        Map<Long,List<String>> venueSportLabelMap = venueSports.parallelStream().collect(Collectors.groupingBy(VenueSport::getVenueId,
                                                 Collectors.mapping(VenueSport::getSportName,Collectors.toList())));

        // 查询场馆地址 市具体地址
        List<Long> cityIds = venues.parallelStream().map(Venue::getCityId).distinct().collect(Collectors.toList());
        List<City> cities  = this.cityService.listByIds(cityIds);
        Map<Long,String> venueCityMap = cities.parallelStream().collect(Collectors.toMap(City::getId,City::getName));
        // 计算距离


        // 组装
        List<VenueBriefVO> venueBriefVOS = venues.parallelStream().map(venue -> VenueBriefVO.builder()
                                          .venueId(venue.getId())
                                          .venueName(venue.getVenueName())
                                          .location(venueCityMap.get(venue.getCityId())+venue.getDetailLocation())
                                          .sportLabel(venueSportLabelMap.get(venue.getId()))
                                          .build()).collect(Collectors.toList());


        return venueBriefVOS;


    }

    @Override
    public Venue selectByPrimaryKey(Long id) {

        return venueMapper.selectByPrimaryKey(id);

    }
//获取场馆基础信息
    @Override
    public VenueInfoVo selectVenueInfoById(Long venueId) {
        //获取场馆信息
        Venue venue = venueMapper.selectByPrimaryKey(venueId);
//        获取场馆基础设施
        List<VenueInfrastructureInfo> venueInfrastructureInfos = venueInfrastructureService.selectVenueInfrastructureInfoByVenueId(venueId);
//        获取场馆功能区
        List<VenueFunctionZoneInfo> venueFunctionZoneInfos = venueFunctionZoneService.selectVenueFunctionZoneInfoByVenueId(venueId);
//        获取场馆品牌介绍
        Brand brand = brandService.selectBrandByVenueId(venueId);
        //数据打包
        VenueInfoVo venueInfoVo= VenueInfoVo.builder()
                .venueId(venue.getId())
                .infrastructuresList(venueInfrastructureInfos)
                .functionZoneInfoList(venueFunctionZoneInfos)
                .brand(brand)
                .intro(venue.getIntro())
                .startWeek(venue.getStartWeek())
                .endWeek(venue.getEndWeek())
                .openTime(venue.getOpenTime())
                .endTime(venue.getEndTime()).
                build();


        return venueInfoVo;
    }


}
