package com.bsehk.business.biz;

import com.alibaba.fastjson.JSON;
import com.bsehk.business.service.SportCategoryDisPlayService;
import com.bsehk.business.service.vo.SportCategoryDisPlayVO;
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
public class SportCategoryDisplayServiceImplTest {

    @Resource
    private SportCategoryDisPlayService sportCategoryDisPlayService;

    @Test
    public void listSportCategoryDisplayVOTest(){
        List<SportCategoryDisPlayVO> sportCategoryDisPlayVOS = sportCategoryDisPlayService.listSportCategoryDisplayVO();

        log.info("sportCategoryDisplayVOs : [{}]", JSON.toJSONString(sportCategoryDisPlayVOS));

    }




}
