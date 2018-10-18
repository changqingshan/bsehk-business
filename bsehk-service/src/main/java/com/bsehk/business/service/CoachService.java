package com.bsehk.business.service;

import com.bsehk.business.domain.Coach;

import java.util.List;

public interface CoachService {
    List<Coach> selectAllCoach();
    Coach selectCoachById(long id);

    List<Coach> listByIds(List<Long> coachIds);
}
