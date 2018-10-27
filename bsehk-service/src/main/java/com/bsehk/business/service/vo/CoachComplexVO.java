package com.bsehk.business.service.vo;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * Created by 24398 on 2018/10/27.
 */
@Data
@Builder
public class CoachComplexVO {
    private Byte coachType ;// 1  -- 教练   2 --- 技师

    private List<CoachVO> coachVOS;

}
