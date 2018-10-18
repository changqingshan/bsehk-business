package com.bsehk.business.service;

import com.bsehk.business.service.vo.CoachVO;

import java.util.List;

public interface CoachService {
    List<CoachVO> selectCoachByVenueId(Long venueId);

}
