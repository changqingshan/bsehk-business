package com.bsehk.business.biz.impl;

import com.bsehk.business.dao.mapper.CoachMapper;
import com.bsehk.business.domain.Coach;

import com.bsehk.business.domain.CoachMedia;
import com.bsehk.business.service.CoachMediaService;
import com.bsehk.business.service.CoachService;
import com.bsehk.business.service.CoachVenueService;
import com.bsehk.business.service.vo.CoachVO;
import com.bsehk.common.exception.BizException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.text.ChoiceFormat;
import java.util.ArrayList;
import java.util.HashMap;
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
    public Map<Byte,List<CoachVO>> selectCoachByVenueId(Long venueId) {
    /*    double [] bannerTypeArray = new double[]{1,2,3,4};
        String[] typeNameArray = new String[]{"咱片","短视频","长视频","资质证明"};
        ChoiceFormat choiceFormat = new ChoiceFormat(bannerTypeArray,typeNameArray);*/

        List<CoachVO> coachVOList = new ArrayList<>();
        //通过场馆id获取教练id集合
        List<Long> coachIdList = coachVenueService.selectByVenueId(venueId);
        if(coachIdList.size() == 0){
          return new HashMap<>();
        }
        //通过教练id集合获取教练的名称，职称，
        List<Coach> coacheList = coachMapper.selectCoachByCoachId(coachIdList);
        //遍历教练集合与教练媒体集合，把两个集合中id相同的对象属性放入CoachVO，把CoachVO存入集合，返回前端

        List<CoachVO> coachVOS  = coacheList.parallelStream().map(coach -> {

            return CoachVO.builder().id(coach.getId())
                                    .coachType(coach.getCoachType())
                                    .title(coach.getTitle())
                                    .name(coach.getCoachName())
                                 //   .appearanceUrl(coach.getAppearanceUrl())
                                    .appearanceUrl("http://img1.imgtn.bdimg.com/it/u=4141238339,394399032&fm=26&gp=0.jpg")
                                    .build();
               }).collect(Collectors.toList());

        Map<Byte,List<CoachVO>> coachMap = coachVOS.parallelStream().collect(Collectors.groupingBy(CoachVO::getCoachType));

        return coachMap;
    }



    @Override
    public CoachVO detailInfo(Long coachId) {
        Coach coach = coachMapper.selectByPrimaryKey(coachId);
        if(coach == null){
            return null;
        }
        List<CoachMedia> coachMediaList = coachMediaService.selectOneByCochId(coachId);
        //类型：1、照片；2、15s短视频；3、长视频；4、资质证明，默认media_type只有1、2、3、4
        Map<Integer, List<CoachMedia>> map = coachMediaList.parallelStream().collect(Collectors.groupingBy(CoachMedia::getMediaType));
        CoachVO coachVO = CoachVO.builder()
                .id(coach.getId())
                .title(coach.getTitle())
                .name(coach.getCoachName())
                .intro(coach.getIntro())
           //     .appearanceUrl(coach.getAppearanceUrl())
                .appearanceUrl("http://img1.imgtn.bdimg.com/it/u=187045518,1243225819&fm=26&gp=0.jpg")
                .photoList(map.get(1))
                .shortVideoList(map.get(2))
                .longVideoList(map.get(3))
                .qualificationList(map.get(4))
                .build();


        return coachVO;
    }
}
