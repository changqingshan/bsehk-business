package com.bsehk.business.biz.impl;

import com.bsehk.business.dao.mapper.SpecialCourseMapper;
import com.bsehk.business.domain.SpecialCourse;
import com.bsehk.business.service.SpecialCourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by 24398 on 2018/10/23.
 */

@Slf4j
@Service
public class SpecialCourseServiceImpl implements SpecialCourseService {

    @Resource
    private SpecialCourseMapper specialCourseMapper;


    @Override
    public SpecialCourse getByVenueId(Long venueId, Boolean isDelete) {
        Date now = new Date();
        SpecialCourse specialCourse = this.specialCourseMapper.selectByVenueId(venueId,now,isDelete);

        return specialCourse;
    }
}
