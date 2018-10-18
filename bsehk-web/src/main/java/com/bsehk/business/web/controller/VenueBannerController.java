package com.bsehk.business.web.controller;

import com.bsehk.business.domain.VenueAdvert;
import com.bsehk.business.domain.VenueNotice;
import com.bsehk.business.service.BrandService;
import com.bsehk.business.service.VenueAdvertService;
import com.bsehk.business.service.VenueBannerService;
import com.bsehk.business.service.VenueNoticeService;
import com.bsehk.business.service.vo.VenueBannerVO;
import com.bsehk.common.response.ResultData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/venue")
public class VenueBannerController {
    @Resource
    VenueBannerService venueBannerService;
    @Resource
    VenueNoticeService venueNoticeService;
    @Resource
    VenueAdvertService venueAdvertService;
    @Resource
    BrandService brandService;

    //场馆banner图分类展示
    @RequestMapping("/selectBannerByVenueId")
    public ResultData selectBannerByVenueId(Long venueId) {
        List<VenueBannerVO> venueBannerVOList = venueBannerService.selectBannerByVenueId(venueId);
        return ResultData.success(venueBannerVOList);
    }

    //场馆公告展示
    @RequestMapping("/selectNoticeByVenueId")
    public ResultData selectNoticeByVenueId(Long venueId) {
        VenueNotice venueNotice = venueNoticeService.selectNoticeByVenueId(venueId);
        return ResultData.success(venueNotice);
    }

    //场馆广告展示
    @RequestMapping("/selectAdvertByVenueId")
    public ResultData selectAdvertByVenueId(Long venueId) {
        VenueAdvert venueAdvert = venueAdvertService.selectAdvertByVenueId(venueId);
        return ResultData.success(venueAdvert);
    }

    //场馆品牌介绍
    @RequestMapping("selectBrandByVenueId")
    public ResultData selectBrandByVenueId(Long venueId){

        return ResultData.success("");
    }
}
