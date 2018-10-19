package com.bsehk.business.service;

import com.bsehk.business.domain.Coach;
import com.bsehk.business.domain.CoachMedia;

import java.util.List;

public interface CoachMediaService {
    List<CoachMedia> selectPhotoByCoachId(List<Coach> coacheList);

    List<CoachMedia> selectOneByCochId(Long venueId);
}
