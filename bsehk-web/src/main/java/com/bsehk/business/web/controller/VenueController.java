package com.bsehk.business.web.controller;
import com.bsehk.business.service.VenueService;
import com.bsehk.business.service.vo.VenueVo;
import com.bsehk.common.exception.BizException;
import com.bsehk.common.response.ResultData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("/venue")
public class VenueController {
    @Resource
    VenueService venueService;

    /*
     * 查询场馆基本信息
     * */
    @RequestMapping("/selectVenue")
    public ResultData selectVenueById(Long id) {
    VenueVo venueVo=venueService.selectVenueById(id);
    if (venueVo==null){
        throw  new BizException("没有找到场馆信息");
    }
        return ResultData.success(venueVo);
    }
}

