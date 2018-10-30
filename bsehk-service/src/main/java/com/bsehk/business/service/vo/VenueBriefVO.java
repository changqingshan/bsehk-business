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
    private String url;
    private String location;
    private Double distance;
    private List<String>  sportLabel;
}
