package com.bsehk.business.biz.impl;

import com.bsehk.business.domain.WxUserInfo;
import com.bsehk.business.service.*;
import com.bsehk.business.service.vo.*;
import com.bsehk.common.exception.BizException;
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
    private WxUserInfoService wxUserInfoService;
    @Resource
    private ProductionService productionService;
    @Resource
    private VenueService venueService;
    @Resource
    private SportCategoryDisPlayService sportCategoryDisPlayService;



    @Override
    public IndexComplexVO getPageHomeData(String  openid, Double longitude, Double latitude,Integer pageNum,Integer pageSize) {
        // 查询城市
        List<CityVO> cityVOS = this.cityService.getCityTree();
        // 查询运动类别
       // List<SportCategory> sportCategories = this.sportCategoryService.selectParentSport();
        List<SportCategoryDisPlayVO> sportCategoryDisPlayVOS = this.sportCategoryDisPlayService.listSportCategoryDisplayVO();
        sportCategoryDisPlayVOS.forEach(sportCategory -> sportCategory.setLogo("http://img3.imgtn.bdimg.com/it/u=828106224,558857673&fm=26&gp=0.jpg"));
        // 查询微信用户的openid 的lastCityId
        WxUserInfo wxUserInfo = this.wxUserInfoService.selectByOpenid(openid,false);
        if(wxUserInfo == null){
            throw new BizException("没有查询到微信用户");
        }

        // 查询场馆
        PageInfo<List<VenueBriefVO>> pageInfo = this.venueService.searchVenue(wxUserInfo.getLastLocationCityId(), null, longitude, latitude, null, pageNum, pageSize);

        IndexComplexVO indexComplexVO = IndexComplexVO.builder()
                                                      .cityVOS(cityVOS)
                                                      .lastLocationId(wxUserInfo.getLastLocationCityId())
                                                      .sportCategoryDisPlayVOS(sportCategoryDisPlayVOS)
                                 //                     .productionVOS()
                                                      .pageInfo(pageInfo)
                                                      .build();

        return indexComplexVO;
    }



    @Override
    public PageInfo<List<VenueBriefVO>> searchIndexVenue(String openid,Long cityId, String venueName, Double longitude, Double latitude,Integer pageNum,Integer pageSize) {
         // 保存切换的城市
         this.wxUserInfoService.saveLastLocationCity(openid,cityId);

        // 查询场馆
        PageInfo<List<VenueBriefVO>> pageInfo = this.venueService.searchVenue(cityId,null,longitude,latitude,venueName, pageNum, pageSize);

        return pageInfo;
    }


    @Override
    public Map<String, Object> secondaryPageData(Long cityId, Long sportCategoryId, Double longitude, Double latitude,Integer pageNum,Integer pageSize) {
        // 查询城市
         List<CityVO> cityVOS = this.cityService.getCityTree();
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
