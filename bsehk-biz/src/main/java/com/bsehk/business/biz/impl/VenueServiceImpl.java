package com.bsehk.business.biz.impl;

import com.bsehk.business.dao.mapper.VenueMapper;
import com.bsehk.business.domain.*;
import com.bsehk.business.service.*;
import com.bsehk.business.service.vo.VenueBriefVO;
import com.bsehk.business.service.vo.VenueComplexVO;
import com.bsehk.common.util.DateUtil;
import com.bsehk.common.util.StringUtil;

import com.snxy.coordinate.gisutil.Coordinate.Coordinate;
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
    private CoachService coachService;
    @Resource
    private SportCategoryService sportCategoryService;
    @Resource
    private VenueSportCategoryService venueSportCategoryService;
    @Resource
    private VenueInfrastructureService venueInfrastructureService;
    @Resource
    VenueBannerService venueBannerService;
    @Resource
    VenueNoticeService venueNoticeService;
    @Resource
    VenueAdvertService venueAdvertService;
    @Resource
    BrandService brandService;

    @Override
    public VenueComplexVO getVenueComplexInfo(Long venueId) {
        //获取场馆信息
        Venue venue = venueMapper.selectByPrimaryKey(venueId);
        //获取场馆所有运动类别
        List<Long> venueIds = new ArrayList<>();
        venueIds.add(venueId);
        List<VenueSport> venueSports = venueSportCategoryService.listVenueSport(venueIds,false);
        //筛选场馆运动类中的小类
        List<VenueSport> venueSmallSports = new ArrayList<>();
        for (int i=0;i<venueSports.size();i++){
            if(venueSports.get(i).getParentId()!=0){
                venueSmallSports.add(venueSports.get(i));
            }
        }
        //获取免费设施
        List<VenueInfrastructureInfo> venueInfrastructureInfos = venueInfrastructureService.pageVenueInfrastructureInfoByVenueId(venueId,1,3,false);
       venueInfrastructureInfos.forEach(venueInfrastructureInfo -> venueInfrastructureInfo.setLogo("http://img1.imgtn.bdimg.com/it/u=14004142,3966287589&fm=26&gp=0.jpg"));

        // 查询场馆普通banner图数量
        Integer bannerNumber = this.venueBannerService.numberBanner(venueId,false);
        //获取场馆公告展示
        VenueNotice venueNotice = venueNoticeService.selectNoticeByVenueId(venueId,(byte)1,false);
        //获取场馆广告展示
        VenueAdvert venueAdvert = venueAdvertService.selectAdvertByVenueId(venueId,false);
        //获取场馆品牌介绍
        Brand brand = brandService.selectBrandByVenueId(venueId);
        // 场馆教练
      //  List<Coach> coaches = this.coachService.selectCoachByVenueId(venueId);
        // 场馆技师

        //数据打包
        VenueComplexVO venueComplexVO = VenueComplexVO.builder()
                        .venueId(venueId)
                        .venueName(venue.getVenueName())
                        .url(venue.getUrl())
                        .bannerNumber(bannerNumber)
                        .detailLocation(venue.getDetailLocation())
                        .mobile(venue.getMobile())
                        .startWeek(venue.getStartWeek())
                        .endWeek(venue.getEndWeek())
                        .openTime(DateUtil.date2Str(venue.getOpenTime(),"HH:mm"))
                        .endTime(DateUtil.date2Str(venue.getEndTime(),"HH:mm"))
                        .venueSportList(venueSmallSports)
                        .infrastructuresList(venueInfrastructureInfos)
                        .venueNotice(venueNotice)
                        .venueAdvert(venueAdvert)
                        .brand(brand)
                        .build();

        return venueComplexVO;
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
        List<VenueSport> venueSports = this.venueSportCategoryService.listVenueSport(venueIds,false);
        Map<Long,List<String>> venueSportLabelMap = venueSports.parallelStream().collect(Collectors.groupingBy(VenueSport::getVenueId,
                                                 Collectors.mapping(VenueSport::getSportName,Collectors.toList())));

        // 查询场馆地址 市具体地址
        List<Long> cityIds = venues.parallelStream().map(Venue::getCityId).distinct().collect(Collectors.toList());
        List<City> cities  = this.cityService.listByIds(cityIds);
        Map<Long,String> venueCityMap = cities.parallelStream().collect(Collectors.toMap(City::getId,City::getName));
        // 计算距离
         Map<Long,Double> distanceMap = new HashMap<>();
         if(latitude != null && longitude != null){
             venues.forEach(venue -> {
                 Double distance = Coordinate.getDistanceOfGCJ02Pts(latitude,longitude,venue.getLatitude(),venue.getLongitude());
                distanceMap.put(venue.getId(),distance);
             });
         }


        // 组装
        List<VenueBriefVO> venueBriefVOS = venues.parallelStream().map(venue -> VenueBriefVO.builder()
                                          .venueId(venue.getId())
                                          .venueName(venue.getVenueName())
                                          .distance(distanceMap.get(venue.getId()))
                                          .location("500m")
                             //             .location(venueCityMap.get(venue.getCityId())+venue.getDetailLocation())
                                          .sportLabel(venueSportLabelMap.get(venue.getId()))
                                          .build()).collect(Collectors.toList());


        return venueBriefVOS;


    }

    @Override
    public Venue selectByPrimaryKey(Long id) {
        return venueMapper.selectByPrimaryKey(id);

    }

}
