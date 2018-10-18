package com.bsehk.business.biz;

import com.alibaba.fastjson.JSON;
import com.bsehk.business.service.SportCategoryService;
import com.bsehk.business.service.vo.SportCategoryVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 24398 on 2018/10/18.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SportCategoryServiceTest {
    @Resource
    private SportCategoryService sportCategoryService;

    @Test
    public void selectAllTest(){
        List<SportCategoryVO> sportCategoryVOS = sportCategoryService.selectAllSport();
        log.info("sportCategoryVOS : [{}]", JSON.toJSONString(sportCategoryVOS));
    }

}
