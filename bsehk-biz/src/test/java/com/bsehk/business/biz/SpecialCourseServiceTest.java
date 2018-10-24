package com.bsehk.business.biz;

import com.bsehk.business.domain.SpecialCourse;
import com.bsehk.business.service.SpecialCourseService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * Created by 24398 on 2018/10/23.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SpecialCourseServiceTest {
    
    @Resource
    private SpecialCourseService specialCourseService;
    
    @Test
    public void getByVenueIdTest(){
        SpecialCourse specialCourse = specialCourseService.getByVenueId(1L, false);
        log.info("SpecialCourse :  [{}]",specialCourse);
    }

}
