package com.bsehk.business.service;

import com.bsehk.business.domain.VenueSport;
import com.bsehk.business.domain.VenueSportCategory;

import java.util.List;

public interface VenueSportCategoryService {
    List<VenueSport> listVenueSport(List<Long> venueIds,Boolean isDelete);
    VenueSportCategory selectById(Long id);
}
