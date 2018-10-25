package com.bsehk.business.dao.mapper;

import com.bsehk.business.domain.SportCategoryDisplay;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SportCategoryDisplayMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SportCategoryDisplay record);

    int insertSelective(SportCategoryDisplay record);

    SportCategoryDisplay selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SportCategoryDisplay record);

    int updateByPrimaryKey(SportCategoryDisplay record);

    List<SportCategoryDisplay> listAll(@Param("isDelete") Boolean  isDelete);
}