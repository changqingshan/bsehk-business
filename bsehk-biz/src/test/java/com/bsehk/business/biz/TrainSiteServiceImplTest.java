package com.bsehk.business.biz;

import com.bsehk.business.service.TrainSiteService;
import com.bsehk.business.service.vo.TrainSiteVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 24398 on 2018/10/25.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class TrainSiteServiceImplTest {

    @Resource
    private TrainSiteService trainSiteService;

    @Test
    public void listTrainSite(){
        List<TrainSiteVO> trainSiteVOS = trainSiteService.listTrainSite(1L, null, null, null);
        log.info("trainSite :   [{}]",trainSiteVOS);
    }



}
