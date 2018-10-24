package com.bsehk.business.biz;

import com.bsehk.business.service.ExerciseFieldNoticeService;
import lombok.extern.slf4j.Slf4j;
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
public class ExerciseFieldNoticeServiceTest {

    @Resource
    private ExerciseFieldNoticeService exerciseFieldNoticeService;

}
