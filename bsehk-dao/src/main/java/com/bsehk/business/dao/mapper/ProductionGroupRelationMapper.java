package com.bsehk.business.dao.mapper;

import com.bsehk.business.domain.ProductionGroupRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductionGroupRelationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ProductionGroupRelation record);

    int insertSelective(ProductionGroupRelation record);

    ProductionGroupRelation selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ProductionGroupRelation record);

    int updateByPrimaryKey(ProductionGroupRelation record);

    Long numberProduction(@Param("venueProductionGroupId") Long venueProductionGroupId,@Param("isDelete") Boolean isDelete);

    List<ProductionGroupRelation> listProductionRelation( @Param("venueProductionGroupId") Long venueProductionGroupId, @Param("isDelete") Boolean isDelete);
}