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


    /**
     *  获取所有教练
     * @return
     */
    public List<Coach> selectAllCoach(){

       // List<Coach> coachList=coachMapper.selectAllCoach();
       return  null;
    }

    @Override
    public Coach selectCoachById(long id) {
        return null;
    }

    /**
     *  获取单个教练信息
     * @return
     */



    @Override
    public List<Coach> listByIds(List<Long> coachIds) {
       List<Coach> coaches = this.coachMapper.listByIds(coachIds);
        return coaches;
    }


    @Override
    public List<CoachVO> selectCoachByVenueId(Long venueId) {
        List<CoachVO> coachVOList = new ArrayList<>();

        //通过场馆id获取教练id集合
        List<Long> coachIdList = coachVenueService.selectByVenueId(venueId);
        if(coachIdList.size() == 0){
            throw new BizException("该场馆没有教练");
        }
        //通过教练id集合获取教练的名称，职称，
        List<Coach> coacheList = coachMapper.selectCoachByCoachId(coachIdList);
        //通过教练的id获取教练的topphoto，id，放入coachMedia集合
        List<CoachMedia> coachMediaList = coachMediaService.selectPhotoByCoachId(coacheList);
        //遍历教练集合与教练媒体集合，把两个集合中id相同的对象属性放入CoachVO，把CoachVO存入集合，返回前端
/*        for (int i = 0; i<coacheList.size();i++){
            for (int j=0;j<coachMediaList.size();j++){
                //如果coach的id与coachMedia的coachId相同，把俩个对象的信息存入coachVO
                if(coacheList.get(i).getId() == coachMediaList.get(j).getCoachId()){
                    CoachVO coachVO =  CoachVO.builder()
                                              .id(coacheList.get(i).getId())
                                              .title(coacheList.get(i).getTitle())
                                              .name(coacheList.get(i).getName())
                                              .topPhotoUrl(coachMediaList.get(j).getUrl())
                                              .build();

                    coachVOList.add(coachVO);

                }
            }

        }*/


        List<CoachVO> coachVOS  = coacheList.parallelStream().map(coach -> {
            CoachMedia coachMedia = coachMediaList.parallelStream().filter(coachMedia1 ->
                                                     coachMedia1.getCoachId().equals(coach.getId()))
                                         .findFirst().orElse(null);

            return CoachVO.builder().id(coach.getId())
                                    .title(coach.getTitle())
                                    .name(coach.getName())
                                    .topPhotoUrl(coachMedia.getUrl())
                                    .build();
               }).collect(Collectors.toList());



        return coachVOList;
    }

    @Override
    public CoachVO selectCoachInfoById(Long coachId) {
        Coach coach = coachMapper.selectByPrimaryKey(coachId);
        List<CoachMedia> coachMediaList = coachMediaService.selectOneByCochId(coachId);
        //类型：1、照片；2、15s短视频；3、长视频；4、资质证明，默认media_type只有1、2、3、4
        Map<Integer, List<CoachMedia>> map = coachMediaList.parallelStream().collect(Collectors.groupingBy(CoachMedia::getMediaType));
        CoachVO coachVO = CoachVO.builder()
                        .id(coach.getId())
                        .title(coach.getTitle())
                        .name(coach.getName())
                        .intro(coach.getIntro())
                        .photoList(map.get(1))
                        .shortVideoList(map.get(2))
                        .longVideoList(map.get(3))
                        .qualificationList(map.get(4))
                        .build();
        for (int i = 0;i<map.get(1).size();i++){
            if(map.get(1).get(i).getIsTop() == 1){
                coachVO.setTopPhotoUrl(map.get(1).get(i).getUrl());
            }
        }

        return coachVO;
    }

}
