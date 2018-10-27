package com.bsehk.business.biz.impl;

import com.bsehk.business.dao.mapper.CoachMapper;
import com.bsehk.business.domain.Coach;

import com.bsehk.business.domain.CoachMedia;
import com.bsehk.business.service.CoachMediaService;
import com.bsehk.business.service.CoachService;
import com.bsehk.business.service.CoachVenueService;
import com.bsehk.business.service.vo.CoachComplexVO;
import com.bsehk.business.service.vo.CoachVO;
import com.bsehk.common.exception.BizException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;

import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CoachServiceImpl implements CoachService {

    @Resource
    CoachMapper coachMapper;
    @Resource
    CoachVenueService coachVenueService;
    @Resource
    CoachMediaService coachMediaService;

    @Override
    public List<Coach> listByIds(List<Long> coachIds,Boolean isDeleted) {
       List<Coach> coaches = this.coachMapper.listByIds(coachIds,isDeleted);
        return coaches;
    }


    @Override
    public CoachComplexVO selectCoachByVenueId(Long venueId) {
        List<CoachVO> coachVOList = new ArrayList<>();

        //通过场馆id获取教练id集合
        List<Long> coachIdList = coachVenueService.selectByVenueId(venueId);
        if (coachIdList.size() == 0) {
            throw new BizException("该场馆没有教练");
        }
        //通过教练id集合获取教练的名称，职称，
        List<Coach> coacheList = coachMapper.selectCoachByCoachId(coachIdList);
        //通过教练的id获取教练的topphoto，id，放入coachMedia集合
        List<CoachVO> coachVOS = coacheList.parallelStream().map(coach -> {
            return CoachVO.builder().id(coach.getId())
                    .coachType(coach.getCoachType())
                    .title(coach.getTitle())
                    .name(coach.getCoachName())
                    .appearanceUrl("http://pic.58pic.com/58pic/10/97/02/30a58PICH7N.jpg")
                    .build();
        }).collect(Collectors.toList());
        CoachComplexVO coachComplexVO = CoachComplexVO.builder().build();
        Map<Byte,List<CoachVO>> map = coachVOS.parallelStream().collect(Collectors.groupingBy(CoachVO::getCoachType));
        map.forEach((k,v) ->{
            coachComplexVO.setCoachType(k);
            coachComplexVO.setCoachVOS(v);
        });

        return  coachComplexVO;
    }
    @Override
    public CoachVO detailInfo(Long coachId) {
        Coach coach = coachMapper.selectByPrimaryKey(coachId);
        List<CoachMedia> coachMediaList = coachMediaService.selectOneByCochId(coachId);
        //类型：1、照片；2、15s短视频；3、长视频；4、资质证明，默认media_type只有1、2、3、4
        Map<Integer, List<CoachMedia>> map = coachMediaList.parallelStream().collect(Collectors.groupingBy(CoachMedia::getMediaType));
        CoachVO coachVO = CoachVO.builder()
                        .id(coach.getId())
                        .title(coach.getTitle())
                        .name(coach.getCoachName())
                        .intro(coach.getIntro())
                        .photoList(map.get(1))
                        .shortVideoList(map.get(2))
                        .longVideoList(map.get(3))
                        .qualificationList(map.get(4))
                        .build();
        return coachVO;
    }

}
