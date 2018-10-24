package com.bsehk.business.biz.impl;

import com.bsehk.business.dao.mapper.VenueBannerMapper;
import com.bsehk.business.dao.mapper.VenueNoticeMapper;
import com.bsehk.business.domain.VenueNotice;
import com.bsehk.business.service.VenueNoticeService;
import com.bsehk.common.exception.BizException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
@Slf4j
public class VenueNoticeServiceImpl implements VenueNoticeService {
    @Resource
    VenueNoticeMapper venueNoticeMapper;
    @Override
    public VenueNotice selectNoticeByVenueId(Long venueId,Byte noticeType,Boolean isDelete) {
        //获取当前日期
        Date now = new Date();
        VenueNotice venueNotice = venueNoticeMapper.selectByVenueIdAndType(venueId, noticeType.intValue(),now,false);
        log.info("venueNotice :  [{}]" ,venueNotice);

        return venueNotice;
    }


}
