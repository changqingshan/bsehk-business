package com.bsehk.business.web.controller;


import com.bsehk.business.domain.Coach;
import com.bsehk.business.service.CoachService;
import com.bsehk.business.service.vo.CoachVO;
import com.bsehk.common.exception.BizException;

import com.bsehk.common.response.ResultData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/coach")
public class CoachController {
    @Resource
    CoachService coachService;

    /**
     * 查询教练列表
     */
    @RequestMapping("selectAllCoach")
    public ResultData selectAllCoach(){
        List<Coach> coachList=coachService.selectAllCoach();
        if (coachList.size()==0){
            throw new BizException("没有找到教练");
        }
        return ResultData.success(coachList);
    }
    /**
     * 查询单个教练
     */
    @RequestMapping("selectCoachById")
    public ResultData selectCoachById(long id){
        Coach coach=coachService.selectCoachById(id);
        if (coach==null){
            throw new BizException("没有该教练信息");
        }
        return ResultData.success(coach);
    }



    /*
    * 教练展示接口
    * */
    @RequestMapping("/selectCoachByVenueId")
    public ResultData selectCoachByVenueId(Long venueId) {
        List<CoachVO> coachVOList = coachService.selectCoachByVenueId(venueId);
        return ResultData.success(coachVOList);
    }

    /*
    * 教练详情展示
    * */

}
