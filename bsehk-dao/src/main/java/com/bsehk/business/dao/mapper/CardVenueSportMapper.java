package com.bsehk.business.dao.mapper;

import com.bsehk.business.domain.CardVenueSport;

public interface CardVenueSportMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CardVenueSport record);

    int insertSelective(CardVenueSport record);

    CardVenueSport selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CardVenueSport record);

    int updateByPrimaryKey(CardVenueSport record);
}