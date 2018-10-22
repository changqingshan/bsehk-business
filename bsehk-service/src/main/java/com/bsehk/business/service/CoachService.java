package com.bsehk.business.service;


import com.bsehk.business.domain.Coach;
import com.bsehk.business.service.vo.CoachVO;


import java.util.List;

public interface CoachService {

    List<Coach> listByIds(List<Long> coachIds);

    List<CoachVO> selectCoachByVenueId(Long venueId);

    CoachVO selectCoachInfoById(Long coachId);

}
