package com.bsehk.business.web.controller;
import com.bsehk.business.domain.Brand;
import com.bsehk.business.domain.VenueAdvert;
import com.bsehk.business.domain.VenueNotice;
import com.bsehk.business.service.*;
import com.bsehk.business.service.vo.VenueBannerVO;
import com.bsehk.business.service.vo.VenueComplexVO;
import com.bsehk.business.service.vo.VenueInfoVo;
import com.bsehk.common.response.ResultData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/venue")
public class VenueController {
    @Resource
    VenueService venueService;
    @Resource
    VenueBannerService venueBannerService;
    @Resource
    VenueNoticeService venueNoticeService;
    @Resource
    VenueAdvertService venueAdvertService;
    @Resource
    BrandService brandService;

    /*
     * 查询场馆信息
     * */
    @RequestMapping("/selectVenueInfo")
    public ResultData selectVenueInfoById(Long venueId) {
        VenueInfoVo venueInfoVo = venueService.selectVenueInfoById(venueId);
        return ResultData.success(venueInfoVo);
    }
    /**
     * 查询场馆banner图展示
     */
    @RequestMapping("/selectBannerByVenueId")
    public ResultData selectBannerByVenueId(Long venueId){
        List<VenueBannerVO> venueBannerVOS = venueBannerService.selectBannerByVenueId(venueId);
        return  ResultData.success(venueBannerVOS);
    }
    /**
     *查询场馆公告展示
     */
    @RequestMapping("/selectNoticeByVenueId")
    public ResultData selectNoticeByVenueId(Long venueId){
        VenueNotice venueNotice = venueNoticeService.selectNoticeByVenueId(venueId,  false);
        return  ResultData.success(venueNotice);
    }
    /**
     * 查询场馆广告
     */
    @RequestMapping("/selectAdvertByVenueId")
    public ResultData selectAdvertByVenueId(Long venueId){
        VenueAdvert venueAdvert = venueAdvertService.selectAdvertByVenueId(venueId, false);
        return ResultData.success(venueAdvert);
    }
    /**
     * 查询场馆品牌
     */
    @RequestMapping("/selectBrandByVenueId")
    public  ResultData selectBrandByVenueId(Long venueId){
        Brand brand = brandService.selectBrandByVenueId(venueId);
        return ResultData.success(brand);
    }
    /**
     * 查询场馆综合
     */
    @RequestMapping("/complexInfo")
    public ResultData complexInfo(Long venueId){
        VenueComplexVO venueComplexInfo = venueService.getVenueComplexInfo(venueId);
        return ResultData.success(venueComplexInfo);
    }
}

