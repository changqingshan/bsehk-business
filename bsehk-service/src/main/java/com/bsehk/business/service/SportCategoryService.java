package com.bsehk.business.service;

import com.bsehk.business.domain.SportCategory;
import com.bsehk.business.service.vo.SportCategoryVO;

import java.util.List;

public interface SportCategoryService {
    List<SportCategoryVO> selectAllSport();

    List<SportCategory> selectParentSport();

    List<SportCategory> listByParentId(Long sportCategoryId);
}
