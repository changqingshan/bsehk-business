package com.bsehk.business.biz.impl;

import com.bsehk.business.dao.mapper.CoachMediaMapper;
import com.bsehk.business.domain.Coach;
import com.bsehk.business.domain.CoachMedia;
import com.bsehk.business.service.CoachMediaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class CoachMediaServiceImpl implements CoachMediaService {
    @Resource
    CoachMediaMapper coachMediaMapper;
    @Override
    public List<CoachMedia> selectPhotoByCoachId(List<Coach> coacheList) {
        return coachMediaMapper.selectByCoachId(coacheList);

    }
}
