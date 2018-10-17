package com.bsehk.business.dao;

import com.bsehk.business.dao.mapper.CityMapper;
import com.bsehk.business.domain.City;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * Created by 24398 on 2018/10/17.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class CityTest {

    @Resource
    private CityMapper cityMapper;


    @Test
    public void selectTest1(){
        City city = this.cityMapper.selectByPrimaryKey(1L);
        log.info("city :  [{}]",city);
    }


}
