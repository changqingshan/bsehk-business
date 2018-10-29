package com.bsehk.business.service;

import com.bsehk.business.service.vo.ProductionVO;
import com.bsehk.common.util.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * Created by 24398 on 2018/10/26.
 */
public interface VenueProductionGroupService {
    PageInfo<List<ProductionVO>> pageProduction(Long venueId, Long venueProductionGroupId, Integer pageNum, Integer pageSize);

    Map<String,Object> defaultGroupProduction(Long venueId,Integer pageNum,Integer pageSize);
}
