package com.bsehk.business.web.controller;

import com.bsehk.business.service.IndexService;
import com.bsehk.common.response.ResultData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by 24398 on 2018/10/18.
 */

@RestController
@Slf4j
public class IndexController {

    @Resource
    private IndexService indexService;

    /***
     * 进入首页数据
     * @param cityId
     * @param longitude
     * @param latitude
     * @return
     */
    @RequestMapping("/index/data")
    public ResultData  index(Long cityId,double longitude,double latitude){
        Map<String,Object> map = this.indexService.getPageHomeData(cityId,longitude,latitude);
        return ResultData.success(map);
    }

    /***
     * 首页查询场馆
     * @param cityId
     * @param venueName
     * @param longitude
     * @param latitude
     * @return
     */
    @RequestMapping("/index/search/venue")
    public ResultData searchIndexVenue(Long cityId,String venueName,double longitude,double latitude){
        Map<String,Object> map = this.indexService.searchIndexVenue(cityId,venueName,longitude,latitude);
        return ResultData.success(map);
    }


    /***
     * 进入次级页面时获取数据
     * @param cityId
     * @param sportCategoryId
     * @param longitude
     * @param latitude
     * @return
     */
    @RequestMapping("/secondary/data")
    public ResultData secondaryPage(Long cityId,Long sportCategoryId,double longitude,double latitude){
        Map<String,Object> map  = this.indexService.secondaryPageData( cityId, sportCategoryId, longitude, latitude);
        return ResultData.success(map);
    }

    /****
     * 次级页面查询场馆
     * @param cityId
     * @param sportCategoryId
     * @param longitude
     * @param latitude
     * @return
     */
    @RequestMapping("/secondary/search/venue")
    public ResultData searchVenue(Long cityId,Long sportCategoryId,double longitude,double latitude){
        Map<String,Object> map = this.indexService.searchVenue(cityId,sportCategoryId,longitude,latitude);
        return ResultData.success(map);
    }






}
