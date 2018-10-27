package com.bsehk.business.biz;

import com.alibaba.fastjson.JSON;
import com.bsehk.business.service.CoachService;
import com.bsehk.business.service.vo.CityVO;
import com.bsehk.business.service.vo.CoachComplexVO;
import com.bsehk.business.service.vo.CoachVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by 24398 on 2018/10/23.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class CoachServiceTest {

    @Resource
    private CoachService coachService;

    @Test
    public void selectCoachByVenueIdTest(){
        Long venueId = 1L;
        CoachComplexVO map = this.coachService.selectCoachByVenueId(1L);
        log.info( JSON.toJSONString(map));
    }

    @Test
    public void detailInfo(){
        Long coachId = 1L;
        CoachVO coachVO = this.coachService.detailInfo(coachId);
        log.info("coachVO  :  [{}]",coachVO);
    }



}
