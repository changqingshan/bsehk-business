package com.bsehk.business.service.vo;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * Created by 24398 on 2018/10/17.
 */
@Data
@Builder
public class VenueBriefVO {

    private Long venueId;
    private String venueName;
    private String location;
    private List<String>  sportLabel;
    private Long distance;
}
