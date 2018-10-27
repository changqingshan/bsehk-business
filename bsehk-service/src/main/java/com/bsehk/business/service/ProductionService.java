package com.bsehk.business.service;

import com.bsehk.business.domain.Production;
import com.bsehk.business.service.vo.ProductionVO;
import com.bsehk.common.util.PageInfo;

import java.util.List;

/**
 * Created by 24398 on 2018/10/25.
 */
public interface ProductionService {


    PageInfo<List<ProductionVO>> pageProduction(Long venueId, Integer pageNum, Integer pageSize);

    List<Production> listByIds(List<Long> productionIds, Boolean isDelete);
}