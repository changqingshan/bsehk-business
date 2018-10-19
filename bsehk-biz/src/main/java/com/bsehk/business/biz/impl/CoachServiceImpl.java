package com.bsehk.business.biz.impl;

import com.bsehk.business.dao.mapper.CoachMapper;
import com.bsehk.business.domain.Coach;

import com.bsehk.business.domain.CoachMedia;
import com.bsehk.business.service.CoachMediaService;
import com.bsehk.business.service.CoachService;
import com.bsehk.business.service.CoachVenueService;
import com.bsehk.business.service.vo.CoachVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;

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
    public List<Coach> listByIds(List<Long> coachIds) {
       List<Coach> coaches = this.coachMapper.listByIds(coachIds);
        return coaches;
    }


    @Override
    public List<CoachVO> selectCoachByVenueId(Long venueId) {
        List<CoachVO> coachVOList = new ArrayList<>();
        //通过场馆id获取教练id集合
        List<Long> coachIdList = coachVenueService.selectByVenueId(venueId);
        //通过教练id集合获取教练的名称，职称，
        List<Coach> coacheList = coachMapper.selectCoachByCoachId(coachIdList);
        //通过教练的id获取教练的topphoto，id，放入coachMedia集合
        List<CoachMedia> coachMediaList = coachMediaService.selectPhotoByCoachId(coacheList);
        //遍历教练集合与教练媒体集合，把两个集合中id相同的对象属性放入CoachVO，把CoachVO存入集合，返回前端
        for (int i = 0; i<coacheList.size();i++){
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

        }
        return coachVOList;
    }



}
