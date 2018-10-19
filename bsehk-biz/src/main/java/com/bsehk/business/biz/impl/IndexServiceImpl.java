package com.bsehk.business.biz.impl;

import com.bsehk.business.domain.SportCategory;
import com.bsehk.business.service.CityService;
import com.bsehk.business.service.IndexService;
import com.bsehk.business.service.SportCategoryService;
import com.bsehk.business.service.VenueService;
import com.bsehk.business.service.vo.CityVO;
import com.bsehk.business.service.vo.SportCategoryVO;
import com.bsehk.business.service.vo.VenueBriefVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 24398 on 2018/10/18.
 */

@Service
@Slf4j
public class IndexServiceImpl implements IndexService {

    @Resource
    private CityService cityService;
    @Resource
    private SportCategoryService sportCategoryService;
    @Resource
    private VenueService venueService;



    @Override
    public Map<String, Object> getPageHomeData(Long cityId, double longitude, double latitude) {
        // 查询城市
        List<CityVO> cityVOS = this.cityService.listCity();
        // 查询运动类别
        List<SportCategory> sportCategories = this.sportCategoryService.selectParentSport();
        // 查询场馆
        List<VenueBriefVO> venueBriefVOS = this.venueService.searchVenue(cityId,null,longitude,latitude,null);

        Map<String,Object> map = new HashMap<>();
        map.put("cities",cityVOS);
        map.put("sportCategories",sportCategories);
        map.put("venueBriefInfos",venueBriefVOS);
        return map;
    }



    @Override
    public Map<String, Object> searchIndexVenue(Long cityId, String venueName, double longitude, double latitude) {
        // 查询场馆
        List<VenueBriefVO> venueBriefVOS = this.venueService.searchVenue(cityId,null,longitude,latitude,venueName);

        Map<String,Object> map = new HashMap<>();
        map.put("venueBriefInfos",venueBriefVOS);
        return map;
    }


    @Override
    public Map<String, Object> secondaryPageData(Long cityId, Long sportCategoryId, double longitude, double latitude) {
        // 查询城市
         List<CityVO> cityVOS = this.cityService.listCity();
        // 查询体育类别
        List<SportCategoryVO> sportCategories = this.sportCategoryService.selectAllSport();
        // 条件查询场馆
        List<VenueBriefVO> venueBriefVOS = this.venueService.searchVenue(cityId,sportCategoryId,longitude,latitude,null);

        Map<String,Object> map = new HashMap<>();
        map.put("cities",cityVOS);
        map.put("sportCategories",sportCategories);
        map.put("venueBriefInfos",venueBriefVOS);
        return map;
    }

    @Override
    public Map<String, Object> searchVenue(Long cityId, Long sportCategoryId, double longitude, double latitude) {
        // 查询场馆
        List<VenueBriefVO> venueBriefVOS = this.venueService.searchVenue(cityId,sportCategoryId,longitude,latitude,null);

        Map<String,Object> map = new HashMap<>();
        map.put("venueBriefInfos",venueBriefVOS);
        return map;
    }
}
