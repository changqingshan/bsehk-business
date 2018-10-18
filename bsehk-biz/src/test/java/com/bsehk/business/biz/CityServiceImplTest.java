package com.bsehk.business.biz;

import com.bsehk.business.service.CityService;
import com.bsehk.business.service.vo.CityVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 24398 on 2018/10/17.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class CityServiceImplTest {

    @Resource
    private CityService cityService;

    @Test
    public void listCityTest(){
        List<CityVO> cityVOList = cityService.listCity();
        log.info("cityVOList ------>   [{}]",cityVOList);
    }



}
