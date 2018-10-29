package com.bsehk.business.service;

import com.bsehk.business.service.vo.IndexComplexVO;
import com.bsehk.business.service.vo.VenueBriefVO;
import com.bsehk.common.util.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * Created by 24398 on 2018/10/18.
 */
public interface IndexService {
    IndexComplexVO getPageHomeData(String openid, Double longitude, Double latitude, Integer pageNum, Integer pageSize);

    PageInfo<List<VenueBriefVO>> searchIndexVenue(String openid,Long cityId, String venueName, Double longitude, Double latitude1, Integer pageNum, Integer pageSize);

    Map<String,Object> secondaryPageData(Long cityId, Long sportCategoryId, Double longitude, Double latitude,Integer pageNum,Integer pageSize);

    PageInfo<List<VenueBriefVO>> searchVenue(Long cityId, Long sportCategoryId, Double longitude, Double latitude,Integer pageNum,Integer pageSize);
}
