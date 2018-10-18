package com.bsehk.business.biz;

import com.bsehk.business.domain.VenueSportCategory;
import com.bsehk.business.service.VenueSportCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * Created by 24398 on 2018/10/18.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class VenueSportCategoryTest {

    @Resource
    private VenueSportCategoryService venueSportCategoryService;

    @Test
    public void selectByIdTest(){
        VenueSportCategory venueSportCategory = this.venueSportCategoryService.selectById(1L);
        log.info("venueSportCategory ------>  [{}]",venueSportCategory);
    }

}
