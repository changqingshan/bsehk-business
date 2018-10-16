package com.bsehk.business.dao.mapper;

import com.bsehk.business.domain.TicketType;

public interface TicketTypeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TicketType record);

    int insertSelective(TicketType record);

    TicketType selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TicketType record);

    int updateByPrimaryKey(TicketType record);
}