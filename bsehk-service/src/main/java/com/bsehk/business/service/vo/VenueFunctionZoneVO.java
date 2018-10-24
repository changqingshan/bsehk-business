package com.bsehk.business.service.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VenueFunctionZoneVO {
    private String FunctionZoneName;
    private String logo;
    private Integer FunctionZoneNumber;
}
