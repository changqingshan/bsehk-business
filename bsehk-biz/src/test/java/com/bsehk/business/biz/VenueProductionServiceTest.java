package com.bsehk.business.biz;

import com.bsehk.business.service.VenueProductionGroupService;
import com.bsehk.business.service.vo.ProductionVO;
import com.bsehk.common.util.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 24398 on 2018/10/26.
 */


@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class VenueProductionServiceTest {

    @Resource
    private VenueProductionGroupService venueProductionGroupService;


    @Test
    public void pageProduction(){
        PageInfo<List<ProductionVO>> pageInfo = venueProductionGroupService.pageProduction(1L, 1L, 1, 5);

        log.info("pageInfo :  [{}]",pageInfo);

    }





}
