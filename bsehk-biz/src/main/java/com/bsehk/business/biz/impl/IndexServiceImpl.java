package com.bsehk.business.biz.impl;

import com.bsehk.business.domain.SportCategory;
import com.bsehk.business.service.CityService;
import com.bsehk.business.service.IndexService;
import com.bsehk.business.service.SportCategoryService;
import com.bsehk.business.service.VenueService;
import com.bsehk.business.service.vo.CityVO;
import com.bsehk.business.service.vo.SportCategoryVO;
import com.bsehk.business.service.vo.VenueBriefVO;
import com.bsehk.common.util.PageInfo;
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
    public Map<String, Object> getPageHomeData(Long cityId, Double longitude, Double latitude,Integer pageNum,Integer pageSize) {
        // 查询城市
        List<CityVO> cityVOS = this.cityService.listCity();
        // 查询运动类别
        List<SportCategory> sportCategories = this.sportCategoryService.selectParentSport();
        sportCategories.forEach(sportCategory -> sportCategory.setUrl("http://dpic.tiankong.com/9a/ee/QJ6203205716.jpg"));

        // 查询场馆
        PageInfo<List<VenueBriefVO>> pageInfo = this.venueService.searchVenue(cityId, null, longitude, latitude, null, pageNum, pageSize);

        Map<String,Object> map = new HashMap<>();
        map.put("cities",cityVOS);
        map.put("sportCategories",sportCategories);
        map.put("pageInfo",pageInfo);
        return map;
    }



    @Override
    public PageInfo<List<VenueBriefVO>> searchIndexVenue(Long cityId, String venueName, Double longitude, Double latitude,Integer pageNum,Integer pageSize) {
        // 查询场馆
        PageInfo<List<VenueBriefVO>> pageInfo = this.venueService.searchVenue(cityId,null,longitude,latitude,venueName, pageNum, pageSize);

        return pageInfo;
    }


    @Override
    public Map<String, Object> secondaryPageData(Long cityId, Long sportCategoryId, Double longitude, Double latitude,Integer pageNum,Integer pageSize) {
        // 查询城市
         List<CityVO> cityVOS = this.cityService.listCity();
        // 查询体育类别
        List<SportCategoryVO> sportCategories = this.sportCategoryService.selectAllSport();
        // 条件查询场馆
        PageInfo<List<VenueBriefVO>> pageInfo = this.venueService.searchVenue(cityId,sportCategoryId,longitude,latitude,null,pageNum,pageSize);

        Map<String,Object> map = new HashMap<>();
        map.put("cities",cityVOS);
        map.put("sportCategories",sportCategories);
        map.put("venuePageInfo",pageInfo);
        return map;
    }

    @Override
    public  PageInfo<List<VenueBriefVO>> searchVenue(Long cityId, Long sportCategoryId, Double longitude, Double latitude,Integer pageNum,Integer pageSize) {
        // 查询场馆
        PageInfo<List<VenueBriefVO>> pageInfo = this.venueService.searchVenue(cityId, sportCategoryId, longitude, latitude, null, pageNum, pageSize);

        return pageInfo;
    }
}
