package com.bsehk.business.service.vo;

import lombok.Builder;
import lombok.Data;

/**
 * Created by 24398 on 2018/10/26.
 */
@Data
@Builder
public class ProductionVO {
    private Long productionId;
    private String productionName;
    private String url;
    private String productionPrice;


}
