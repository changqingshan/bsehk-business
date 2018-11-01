package com.bsehk.business.biz.impl;

import com.bsehk.business.dao.mapper.VenueMapper;
import com.bsehk.business.domain.*;
import com.bsehk.business.service.*;

import com.bsehk.common.util.DateUtil;

import com.bsehk.business.service.vo.*;
import com.bsehk.common.util.PageInfo;
import com.bsehk.common.util.StringUtil;

import com.github.pagehelper.PageHelper;
import com.snxy.coordinate.gisutil.Coordinate.Coordinate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
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
    private TrainSiteService trainSiteService;
    @Resource
    VenueBannerService venueBannerService;
    @Resource
    VenueNoticeService venueNoticeService;
    @Resource
    VenueAdvertService venueAdvertService;
    @Resource
    BrandService brandService;
    @Resource
    private FunctionZoneService functionZoneService;
    @Resource
    private CoachService coachService;
    @Resource
    private ProductionService productionService;



    @Override
    public VenueComplexVO
    getVenueComplexInfo(Long venueId) {
        //获取场馆信息
        Venue venue = this.venueMapper.selectByPrimaryKey(venueId);
        // 若为培训机构查询其他培训地点
        Integer otherTrainSiteNumber = null;
        if(venue.getVenueCategory() == 4){
            otherTrainSiteNumber = this.trainSiteService.getTrainSiteNumber(venueId,false);
        }
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
        VenueNotice venueNotice = venueNoticeService.selectNoticeByVenueId(venueId,false);
        //获取场馆广告展示
        VenueAdvert venueAdvert = venueAdvertService.selectAdvertByVenueId(venueId,false);
        //获取场馆品牌介绍
        Brand brand = brandService.selectBrandByVenueId(venueId);
        // 场馆教练技师
        List<CoachComplexVO> coachComplexVOS = this.coachService.selectCoachByVenueId(venueId);
        // 场馆 产品列表
        List<ProductionVO> productionVOS = this.productionService.listProductionVO(venueId,true,false);
       // log.info("productionPageInfo  :  [{}]",productionPageInfo);
        //数据打包
        VenueComplexVO venueComplexVO = VenueComplexVO.builder()
                        .venueId(venueId)
                        .venueName(venue.getVenueName())
                     //   .appearanceUrl(venue.getUrl())
                        .appearanceUrl(venue.getUrl())
                        .bannerNumber(bannerNumber)
                        .otherTrainSite(otherTrainSiteNumber)
                        .detailLocation(venue.getDetailLocation())
                        .mobile(venue.getMobile())
                        .startWeek(venue.getStartWeek())
                        .endWeek(venue.getEndWeek())
                        .openTime(DateUtil.date2Str(venue.getOpenTime(),"HH:mm"))
                        .endTime(DateUtil.date2Str(venue.getEndTime(),"HH:mm"))
                        .venueSportList(venueSmallSports)
                        .infrastructuresList(venueInfrastructureInfos)
                        .coachComplexVOS(coachComplexVOS)
                 //       .productionPageInfo(productionPageInfo)
                        .productionVOS(productionVOS)
                        .venueNotice(venueNotice)
                        .venueAdvert(venueAdvert)
                        .brand(brand)
                        .build();

        return venueComplexVO;
    }




    @Override
    public PageInfo<List<VenueBriefVO>> searchVenue(Long cityId, Long sportCategoryId, Double longitude, Double latitude, String venueName,Integer pageNum,Integer pageSize) {
        if(StringUtil.isBlank(venueName)){
           venueName = null;
        }

        List<Long> sportCategoryIds;
        if(sportCategoryId == null){
            // 选择一级页的全部运动标签或者没有选择运动标签
            sportCategoryIds = Collections.emptyList();
        }else if(  sportCategoryId > 0){
            sportCategoryIds = new ArrayList<>();
             SportCategory sportCategory = this.sportCategoryService.selectById(sportCategoryId);
             if(sportCategory.getIsParent()){
                 // 一级标题   刚进入二级页
                 List<SportCategory> sportCategories = this.sportCategoryService.listByParentId(sportCategoryId);
                 sportCategoryIds = sportCategories.parallelStream().map(SportCategory::getId).collect(Collectors.toList());
             }else{
                 // 二级运动标签  刚进入二级页 或者二级页中选择的的二级标签
               sportCategoryIds.add(sportCategoryId);
             }
        }else{
            // 该运动大类下所有的运动
            //为负数
            Long primarySportCategoryId = Math.abs(sportCategoryId);
            List<SportCategory> sportCategories = this.sportCategoryService.listByParentId(primarySportCategoryId);
            sportCategoryIds = sportCategories.parallelStream().map(SportCategory::getId).collect(Collectors.toList());
        }

        // 查询场馆数量
        Long total = this.venueMapper.searchVenueNum(cityId,sportCategoryIds,venueName);
        // 分页查询场馆
        PageHelper.startPage(pageNum,pageSize);
        List<Venue> venues = this.venueMapper.searchVenue(cityId,sportCategoryIds,venueName);
        if(venues == null || venues.isEmpty()){
            return new PageInfo<>();
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
                                          .url(venue.getUrl())
                                          .distance(distanceMap.get(venue.getId()))
                                          .location(this.convertDistance(distanceMap.get(venue.getId())))
                             //             .location(venueCityMap.get(venue.getCityId())+venue.getDetailLocation())
                                          .sportLabel(venueSportLabelMap.get(venue.getId()))
                                          .build()).collect(Collectors.toList());


        PageInfo<List<VenueBriefVO>> pageInfo = new PageInfo(pageNum,pageSize,total,venueBriefVOS);

        return pageInfo;


    }

    public String convertDistance(Double distance){
        if(distance == null){
            return "";
        }
        if(distance > 50000){
            // 大于50km 不显示距离
            return " -- ";
        }else if(distance > 1000){
            DecimalFormat format = new DecimalFormat("###.##");
            return   format.format(distance/1000);
        }else{
            DecimalFormat format = new DecimalFormat("###");
            return format.format(distance);
        }

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
        List<VenueFunctionZoneVO> venueFunctionZoneVOS = new ArrayList<>();
        //获取场馆基础设施
        List<VenueInfrastructureInfo> venueInfrastructureInfos = venueInfrastructureService.selectVenueInfrastructureInfoByVenueId(venueId,false);
        //获取场馆功能区
        List<VenueFunctionZone> venueFunctionZones = this.venueFunctionZoneService.listByVenueId(venueId,false);
        List<Long> functionZoneIds = venueFunctionZones.parallelStream().map(VenueFunctionZone::getFunctionZoneId).distinct().collect(Collectors.toList());
        List<FunctionZone> functionZones = this.functionZoneService.listByIds(functionZoneIds,false);
        Map<Long,String> map = functionZones.parallelStream().collect(Collectors.toMap(FunctionZone::getId, FunctionZone::getFunctionZoneName));

       for (int i = 0; i<functionZones.size();i++){
            for (int j=0;j<venueFunctionZones.size();j++)
                if (functionZones.get(i).getId().equals( venueFunctionZones.get(j).getFunctionZoneId())) {
                    VenueFunctionZoneVO venueFunctionZoneVO = VenueFunctionZoneVO.builder()
                            .functionZoneNumber(venueFunctionZones.get(j).getFunctionZoneNumber())
                            .logo(functionZones.get(i).getLogo())
                            .functionZoneName(functionZones.get(i).getFunctionZoneName())
                            .build();
                    venueFunctionZoneVOS.add(venueFunctionZoneVO);
                }
        }

        //获取场馆品牌介绍
        Brand brand = brandService.selectBrandByVenueId(venueId);
        //数据打包
        VenueInfoVo venueInfoVo= VenueInfoVo.builder()
                .venueId(venue.getId())
                .infrastructuresList(venueInfrastructureInfos)
                .functionZoneList(venueFunctionZoneVOS)
                .brand(brand)
                .startWeek(venue.getStartWeek()+"")
                .endWeek(venue.getEndWeek()+"")
                .openTime(venue.getOpenTime()+"")
                .endTime(venue.getEndTime()+"").
                build();
        //时间格式转换
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String openTime = format.format(venue.getOpenTime());
        String endTime = format.format(venue.getEndTime());
        venueInfoVo.setOpenTime(openTime.substring(10));
        venueInfoVo.setEndTime(endTime.substring(10));
        if (venue.getStartWeek()==1){
            venueInfoVo.setStartWeek("周一");
        }else if(venue.getStartWeek()==2){
            venueInfoVo.setStartWeek("周二");
        }else if(venue.getStartWeek()==3){
            venueInfoVo.setStartWeek("周三");
        }else if(venue.getStartWeek()==4){
            venueInfoVo.setStartWeek("周四");
        }else if(venue.getStartWeek()==5){
            venueInfoVo.setStartWeek("周五");
        }else if(venue.getStartWeek()==6){
            venueInfoVo.setStartWeek("周六");
        }else if(venue.getStartWeek()==7){
            venueInfoVo.setStartWeek("周日");
        }
        if (venue.getEndWeek()==1){
            venueInfoVo.setEndWeek("周一");
        }else if(venue.getEndWeek()==2){
            venueInfoVo.setEndWeek("周二");
        }else if(venue.getEndWeek()==3){
            venueInfoVo.setEndWeek("周三");
        }else if(venue.getEndWeek()==4){
            venueInfoVo.setEndWeek("周四");
        }else if(venue.getEndWeek()==5){
            venueInfoVo.setEndWeek("周五");
        }else if(venue.getEndWeek()==6){
            venueInfoVo.setEndWeek("周六");
        }else if(venue.getEndWeek()==7){
            venueInfoVo.setEndWeek("周日");
        }

        return venueInfoVo;
    }


}
