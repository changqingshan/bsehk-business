package com.bsehk.business.web.controller;
import com.bsehk.business.service.VenueService;
import com.bsehk.business.service.vo.VenueInfoVo;
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
     * 查询场馆信息
     * */
    @RequestMapping("/selectVenueInfo")
    public ResultData selectVenueInfoById(Long venueId) {
        VenueInfoVo venueInfoVo = venueService.selectVenueInfoById(venueId);
        return ResultData.success(venueInfoVo);
    }
}

