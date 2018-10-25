package com.bsehk.business.biz.impl;

import com.bsehk.business.dao.mapper.TrainSiteMapper;
import com.bsehk.business.domain.City;
import com.bsehk.business.domain.TrainSiteInfo;
import com.bsehk.business.service.CityService;
import com.bsehk.business.service.TrainSiteService;
import com.bsehk.business.service.vo.TrainSiteVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by 24398 on 2018/10/24.
 */

@Service
@Slf4j
public class TrainSiteServiceImpl implements TrainSiteService {

    @Resource
    private TrainSiteMapper trainSiteMapper;
    @Resource
    private CityService cityService;

    @Override
    public List<TrainSiteVO> listTrainSite( Long venueId, Long provinceId, Long cityId,Long districtId) {
        List<TrainSiteInfo> trainSiteInfos = this.trainSiteMapper.listTrainSiteInfo(venueId,provinceId,cityId,districtId,false);
        // 选择城市
        List<City> cities = cityService.listAll(false);
        Map<Long,String> cityMap = cities.parallelStream().collect(Collectors.toMap(City::getId,City::getName));
        //组合
        List<TrainSiteVO> trainSiteVOS = trainSiteInfos.parallelStream().map(trainSiteInfo ->TrainSiteVO.builder()
                                                  .trainSiteId(trainSiteInfo.getId())
                                                  .trainVenueName(trainSiteInfo.getTrainVenueName())
                                                  .siteLocation(new StringBuilder(cityMap.get(trainSiteInfo.getProvinceId()))
                                                        .append(cityMap.get(trainSiteInfo.getCityId()))
                                                        .append(cityMap.get(trainSiteInfo.getDistrictId()))
                                                        .append(trainSiteInfo.getDetailLocation())
                                                        .toString())
                                                  .build())
                                             .collect(Collectors.toList());

        return trainSiteVOS;
    }


    @Override
    public Integer getTrainSiteNumber(Long venueId,Boolean isDelete) {
        Integer number = this.trainSiteMapper.getTrainSiteNumber(venueId,false);
        return number;
    }
}
