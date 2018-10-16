package com.bsehk.business.dao.mapper;

import com.bsehk.business.domain.TicketSaleTime;

public interface TicketSaleTimeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TicketSaleTime record);

    int insertSelective(TicketSaleTime record);

    TicketSaleTime selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TicketSaleTime record);

    int updateByPrimaryKey(TicketSaleTime record);
}