package com.bsehk.business.dao.mapper;

import com.bsehk.business.domain.SportCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SportCategoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SportCategory record);

    int insertSelective(SportCategory record);

    SportCategory selectByPrimaryKey(Long id);

    List<SportCategory> selectAllSport();

    List<SportCategory> selectSportByParentId(Long parentId);

    int updateByPrimaryKeySelective(SportCategory record);

    int updateByPrimaryKey(SportCategory record);

    List<SportCategory> listByParentId(@Param("parentId") Long sportCategoryId,@Param("isDeleted") Boolean isDeleted);
}