package com.bsehk.business.biz;

import com.bsehk.business.domain.VenueNotice;
import com.bsehk.business.service.VenueNoticeService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * Created by 24398 on 2018/10/22.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class VenueNoticeTest {

    @Resource
    private VenueNoticeService venueNoticeService;

    @Test
    public void getExerciseNoticeTest(){
       // VenueNotice venueNotice = this.venueNoticeService.getExerciseNotice(1L,(byte)1,false);
    }



}
