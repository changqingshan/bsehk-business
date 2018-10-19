package com.bsehk.business.service;

import java.util.Map;

/**
 * Created by 24398 on 2018/10/18.
 */
public interface IndexService {
    Map<String,Object> getPageHomeData(Long cityId, double longitude, double latitude);

    Map<String,Object> searchIndexVenue(Long cityId, String venueName, double longitude, double latitude1);

    Map<String,Object> secondaryPageData(Long cityId, Long sportCategoryId, double longitude, double latitude);

    Map<String,Object> searchVenue(Long cityId, Long sportCategoryId, double longitude, double latitude);
}
