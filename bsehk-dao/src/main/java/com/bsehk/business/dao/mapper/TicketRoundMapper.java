package com.bsehk.business.dao.mapper;

import com.bsehk.business.domain.TicketRound;

public interface TicketRoundMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TicketRound record);

    int insertSelective(TicketRound record);

    TicketRound selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TicketRound record);

    int updateByPrimaryKey(TicketRound record);
}