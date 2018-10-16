package com.bsehk.business.dao.mapper;

import com.bsehk.business.domain.TicketPrice;

public interface TicketPriceMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TicketPrice record);

    int insertSelective(TicketPrice record);

    TicketPrice selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TicketPrice record);

    int updateByPrimaryKey(TicketPrice record);
}