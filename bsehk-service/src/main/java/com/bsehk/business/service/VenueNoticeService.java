package com.bsehk.business.service;

import com.bsehk.business.domain.VenueNotice;

import java.util.List;

public interface VenueNoticeService {
    VenueNotice selectNoticeByVenueId(Long venueId,Boolean isDelete);

}
