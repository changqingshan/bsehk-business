package com.bsehk.business.service;

import com.bsehk.business.service.vo.TrainSiteVO;

import java.util.List;

/**
 * Created by 24398 on 2018/10/24.
 */
public interface TrainSiteService {
    List<TrainSiteVO> listTrainSite( Long venueId, Long provinceId, Long cityId,Long districtId);

    Integer getTrainSiteNumber(Long venueId,Boolean isDelete);
}
