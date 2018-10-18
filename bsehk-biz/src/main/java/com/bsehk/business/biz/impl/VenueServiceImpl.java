package com.bsehk.business.biz.impl;

import com.bsehk.business.dao.mapper.VenueMapper;
import com.bsehk.business.dao.mapper.VenueSportCategoryMapper;
import com.bsehk.business.domain.City;
import com.bsehk.business.domain.Venue;
import com.bsehk.business.domain.VenueSport;
import com.bsehk.business.domain.VenueSportCategory;
import com.bsehk.business.service.CityService;
import com.bsehk.business.service.VenueService;
import com.bsehk.business.service.VenueSportCategoryService;
import com.bsehk.business.service.vo.VenueBriefVO;
import com.bsehk.common.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
public class VenueServiceImpl implements VenueService {

    @Resource
    private VenueMapper venueMapper;
    @Resource
    private CityService cityService;
    @Resource
    private VenueSportCategoryService venueSportCategoryService;

    @Override
    public List<VenueBriefVO> searchVenue(Long cityId, Long sportCategoryId, double longitude, double latitude, String venueName) {
        if(StringUtil.isBlank(venueName)){
           venueName = null;
        }

        List<Venue> venues = this.venueMapper.searchVenue(cityId,sportCategoryId,venueName);
        if(venues == null || venues.isEmpty()){
            return Collections.emptyList();
        }
        // 查询所有场馆的体育运动标签
        List<Long> venueIds = venues.parallelStream().map(Venue::getId).collect(Collectors.toList());
        List<VenueSport> venueSports = this.venueSportCategoryService.listVenueSport(venueIds);
        Map<Long,List<String>> venueSportLabelMap = venueSports.parallelStream().collect(Collectors.groupingBy(VenueSport::getVenueId,
                                                 Collectors.mapping(VenueSport::getSportName,Collectors.toList())));

        // 查询场馆地址 市具体地址
        List<Long> cityIds = venues.parallelStream().map(Venue::getCityId).collect(Collectors.toList());
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
}
