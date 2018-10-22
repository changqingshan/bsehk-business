package com.bsehk.business.service;

import com.bsehk.business.domain.VenueNotice;

import java.util.List;

public interface VenueNoticeService {
    VenueNotice selectNoticeByVenueId(Long venueId);

    /***
     * 查询变课通知
     * @param venueId
     * @param isDeleted
     * @return
     */
    VenueNotice getExerciseNotice(Long venueId,Boolean isDeleted);
}
