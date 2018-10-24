package com.bsehk.business.service.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * Created by 24398 on 2018/10/23.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SpecialCourseVO {

    private Long title;


    private String intro;

}
