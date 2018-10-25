package com.bsehk.business.service;

import com.bsehk.business.domain.SportCategory;
import com.bsehk.business.service.vo.SportCategoryVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SportCategoryService {
    List<SportCategoryVO> selectAllSport();

    List<SportCategory> selectParentSport();

    List<SportCategory> listByParentId(Long sportCategoryId);

    SportCategory selectById(Long sportCategoryId);

    List<SportCategory> listByIds( List<Long> sportCategoryIds,Boolean isDelete);
}
