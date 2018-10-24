package com.bsehk.business.web.controller;

import com.bsehk.business.domain.Brand;
import com.bsehk.business.domain.VenueAdvert;
import com.bsehk.business.domain.VenueNotice;
import com.bsehk.business.service.*;
import com.bsehk.business.service.vo.VenueBannerVO;
import com.bsehk.business.service.vo.VenueComplexVO;
import com.bsehk.common.response.ResultData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/venue")
public class VenueHomeController {
    @Resource
    VenueBannerService venueBannerService;
    @Resource
    VenueNoticeService venueNoticeService;
    @Resource
    VenueAdvertService venueAdvertService;
    @Resource
    BrandService brandService;
     @Resource
     VenueService venueService;


    //场馆banner图分类展示
    @RequestMapping("/selectBannerByVenueId")
    public ResultData selectBannerByVenueId(Long venueId) {
        List<VenueBannerVO> venueBannerVOList = venueBannerService.selectBannerByVenueId(venueId);
        return ResultData.success(venueBannerVOList);
    }

    //场馆公告展示
    @RequestMapping("/selectNoticeByVenueId")
    public ResultData selectNoticeByVenueId(Long venueId) {
        VenueNotice venueNotice = venueNoticeService.selectNoticeByVenueId(venueId,(byte)1,false);
        return ResultData.success(venueNotice);
    }

    //场馆广告展示
    @RequestMapping("/selectAdvertByVenueId")
    public ResultData selectAdvertByVenueId(Long venueId) {
        VenueAdvert venueAdvert = venueAdvertService.selectAdvertByVenueId(venueId,false);
        return ResultData.success(venueAdvert);
    }

    //场馆品牌介绍
    @RequestMapping("selectBrandByVenueId")
    public ResultData selectBrandByVenueId(Long venueId){
        Brand brand = brandService.selectBrandByVenueId(venueId);
        return ResultData.success(brand);
    }




    @RequestMapping("/complexInfo")
    public ResultData venueComplexInfo(Long venueId) {
        VenueComplexVO venueComplexVO = venueService.getVenueComplexInfo(venueId);
        return ResultData.success(venueComplexVO);
    }

}
