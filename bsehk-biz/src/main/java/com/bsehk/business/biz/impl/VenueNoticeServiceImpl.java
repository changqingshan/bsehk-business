package com.bsehk.business.biz.impl;

import com.bsehk.business.dao.mapper.VenueBannerMapper;
import com.bsehk.business.dao.mapper.VenueNoticeMapper;
import com.bsehk.business.domain.VenueNotice;
import com.bsehk.business.service.VenueNoticeService;
import com.bsehk.common.exception.BizException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class VenueNoticeServiceImpl implements VenueNoticeService {
    @Resource
    VenueNoticeMapper venueNoticeMapper;
    @Override
    public VenueNotice selectNoticeByVenueId(Long venueId) {
        //获取当前日期
        Date nowDate = new Date();
        VenueNotice venueNotice = venueNoticeMapper.selectNoticeByVenueId(venueId);
        if(venueNotice.getExpireTime().before(nowDate)){
            throw new BizException("当前没有发布的公告");
        }
        return venueNotice;
    }
}
