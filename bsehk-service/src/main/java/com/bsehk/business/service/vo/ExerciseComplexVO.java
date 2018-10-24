package com.bsehk.business.service.vo;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by 24398 on 2018/10/23.
 */

@Data
@Builder
//@NoArgsConstructor
public class ExerciseComplexVO {
    private List<ExerciseVO> exerciseVOS;
    private SpecialCourseVO specialCourseVO;

}
