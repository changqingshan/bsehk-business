package com.bsehk.business.service;


import com.bsehk.business.domain.Coach;
import com.bsehk.business.service.vo.CoachComplexVO;
import com.bsehk.business.service.vo.CoachVO;


import java.util.List;
import java.util.Map;

public interface CoachService {



    List<Coach> listByIds(List<Long> coachIds,Boolean isDelete);



    CoachComplexVO selectCoachByVenueId(Long venueId);


    CoachVO detailInfo(Long coachId);
}
