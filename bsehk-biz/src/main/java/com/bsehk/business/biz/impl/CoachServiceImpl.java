package com.bsehk.business.biz.impl;

import com.bsehk.business.dao.mapper.CoachMapper;
import com.bsehk.business.domain.Coach;
import com.bsehk.business.service.CoachService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class CoachServiceImpl implements CoachService {

    @Resource
    CoachMapper coachMapper;
    /**
     *  获取所有教练
     * @return
     */
    public List<Coach> selectAllCoach(){

        List<Coach> coachList=coachMapper.selectAllCoach();
       return  coachList;
    }
    /**
     *  获取单个教练信息
     * @return
     */
    public Coach selectCoachById(long id){
        Coach coach=coachMapper.selectByPrimaryKey(id);
        return  coach;
    }

    @Override
    public List<Coach> listByIds(List<Long> coachIds) {
       List<Coach> coaches = this.coachMapper.listByIds(coachIds);
        return coaches;
    }
}
