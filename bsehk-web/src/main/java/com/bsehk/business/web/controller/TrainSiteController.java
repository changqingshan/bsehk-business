package com.bsehk.business.web.controller;

import com.bsehk.business.service.TrainSiteService;
import com.bsehk.business.service.vo.TrainSiteVO;
import com.bsehk.common.response.ResultData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 24398 on 2018/10/24.
 */

@RestController
@Slf4j
public class TrainSiteController {

    @Resource
    private TrainSiteService trainSiteService;

    /**
     * 根据省市区查询培训机构的培训点
     * @param venueId
     * @param provinceId
     * @param cityId
     * @return
     */
     @RequestMapping("/trainSite/list")
    public ResultData listTrainSite(Long venueId,Long provinceId,Long cityId,Long districtId){
         List<TrainSiteVO> trainSiteVOS = trainSiteService.listTrainSite(venueId,provinceId,cityId,districtId);
        return ResultData.success(trainSiteVOS);
    }


}
