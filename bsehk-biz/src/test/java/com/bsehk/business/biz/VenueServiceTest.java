package com.bsehk.business.biz;

import com.bsehk.business.dao.mapper.VenueMapper;
import com.bsehk.business.domain.Venue;
import com.bsehk.business.service.VenueService;
import com.bsehk.business.service.vo.VenueBriefVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 24398 on 2018/10/18.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class VenueServiceTest {

    @Resource
    private VenueService venueService;
    @Resource
    private VenueMapper venueMapper;



    @Test
    public void getVenueTest(){
        List<Long> list = new ArrayList<>();
        list.add(4L);
        List<Venue> venues = venueMapper.searchVenue(5L,list,"亚泰");
        log.info("venues  ------> [{}]",venues);
    }






}
