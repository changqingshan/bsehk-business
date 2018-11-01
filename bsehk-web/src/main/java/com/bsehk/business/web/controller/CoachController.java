package com.bsehk.business.web.controller;


import com.bsehk.business.service.CoachService;
import com.bsehk.business.service.vo.CoachComplexVO;
import com.bsehk.business.service.vo.CoachVO;

import com.bsehk.common.response.ResultData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/coach")
public class CoachController {
    @Resource
    CoachService coachService;

    /*
    * 教练，技师展示接口
    * */
    @RequestMapping("/selectCoachByVenueId")
    public ResultData selectCoachByVenueId(Long venueId) {
       List<CoachComplexVO> coachComplexVOS = coachService.selectCoachByVenueId(venueId);
        return ResultData.success(coachComplexVOS);
    }

    /*
    * 教练详情展示
    * */
    @RequestMapping("/detail")
    public ResultData detailCoach(Long coachId){
        CoachVO coachVO = coachService.detailInfo(coachId);
        return ResultData.success(coachVO);

    }

}
