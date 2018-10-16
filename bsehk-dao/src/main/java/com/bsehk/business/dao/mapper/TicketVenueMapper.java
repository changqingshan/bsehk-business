package com.bsehk.business.dao.mapper;

import com.bsehk.business.domain.TicketVenue;

public interface TicketVenueMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TicketVenue record);

    int insertSelective(TicketVenue record);

    TicketVenue selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TicketVenue record);

    int updateByPrimaryKey(TicketVenue record);
}