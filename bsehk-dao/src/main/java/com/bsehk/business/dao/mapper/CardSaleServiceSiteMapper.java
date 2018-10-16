package com.bsehk.business.dao.mapper;

import com.bsehk.business.domain.CardSaleServiceSite;

public interface CardSaleServiceSiteMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CardSaleServiceSite record);

    int insertSelective(CardSaleServiceSite record);

    CardSaleServiceSite selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CardSaleServiceSite record);

    int updateByPrimaryKey(CardSaleServiceSite record);
}