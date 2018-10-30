package com.bsehk.business.web.controller;

import com.bsehk.business.service.IndexService;
import com.bsehk.business.service.vo.IndexComplexVO;
import com.bsehk.business.service.vo.VenueBriefVO;
import com.bsehk.common.response.ResultData;
import com.bsehk.common.util.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
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
     * @param
     * @param longitude
     * @param latitude
     * @return
     */
    @RequestMapping("/index/data")
    public ResultData  index(String openid,Double longitude,Double latitude,
                             @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                             @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize){
        log.info("openid : [{}]   ; pageNum : [{}]  ; pageSize : [{}]",openid,pageNum,pageSize);
        IndexComplexVO indexComplexVO = this.indexService.getPageHomeData(openid,longitude,latitude,pageNum,pageSize);
        return ResultData.success(indexComplexVO);
    }

    /***
     * 首页刷新场馆
     * @param cityId
     * @param venueName
     * @param longitude
     * @param latitude
     * @return
     */
    @RequestMapping("/index/search/venue")
    public ResultData searchIndexVenue(String openid ,Long cityId, String venueName, Double longitude, Double latitude,
                                       @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                       @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize){
        log.info("cityId : [{}]   ;   venueName : [{}]  ; pageNum : [{}]  ; pageSize : [{}]",cityId,venueName,pageNum,pageSize);
        PageInfo<List<VenueBriefVO>> pageInfo = this.indexService.searchIndexVenue(openid,cityId,venueName,longitude,latitude,pageNum,pageSize);
        return ResultData.success(pageInfo);
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
    public ResultData secondaryPage(Long cityId,Long sportCategoryId,Double longitude,Double latitude,
                                    @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                    @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize){

        Map<String,Object> map  = this.indexService.secondaryPageData( cityId, sportCategoryId, longitude, latitude,  pageNum,pageSize);
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
    public ResultData searchVenue(Long cityId,Long sportCategoryId,Double longitude,Double latitude,
                                  @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                  @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize){
        PageInfo<List<VenueBriefVO>> pageInfo = this.indexService.searchVenue(cityId,sportCategoryId,longitude,latitude,pageNum,pageSize);
        return ResultData.success(pageInfo);
    }






}
