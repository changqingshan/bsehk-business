package com.bsehk.business.service;

import com.bsehk.business.domain.SpecialCourse;

/**
 * Created by 24398 on 2018/10/23.
 */
public interface SpecialCourseService {

    SpecialCourse getByVenueId(Long venueId,Boolean isDelete);

}
