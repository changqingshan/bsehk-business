package com.bsehk.business.service.vo;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * Created by 24398 on 2018/10/17.
 */
@Data
@Builder
public class CityVO {
    private Long id;
    private String name;
    private Integer level;
    private List<CityVO> children;

}
