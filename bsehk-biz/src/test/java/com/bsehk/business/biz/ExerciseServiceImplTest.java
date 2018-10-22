package com.bsehk.business.biz;

import com.bsehk.business.service.ExerciseService;
import com.bsehk.business.service.vo.ExerciseVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 24398 on 2018/10/21.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ExerciseServiceImplTest {

    @Resource
    private ExerciseService exerciseService;

    @Test
    public void listVenueExerciseTest(){
        List<ExerciseVO> exerciseVOS = exerciseService.listVenueExercise(1L);

        log.info("exerciseVOS : [{}]",exerciseVOS);
    }


}
