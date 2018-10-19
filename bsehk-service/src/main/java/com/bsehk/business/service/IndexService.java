package com.bsehk.business.service;

import java.util.Map;

/**
 * Created by 24398 on 2018/10/18.
 */
public interface IndexService {
    Map<String,Object> getPageHomeData(Long cityId, Double longitude, Double latitude);

    Map<String,Object> searchIndexVenue(Long cityId, String venueName, Double longitude, Double latitude1);

    Map<String,Object> secondaryPageData(Long cityId, Long sportCategoryId, Double longitude, Double latitude);

    Map<String,Object> searchVenue(Long cityId, Long sportCategoryId, Double longitude, Double latitude);
}
