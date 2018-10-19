package com.bsehk.business.domain;

import lombok.Data;

@Data
public class VenueInfrastructureInfo {
    private Long venueId;
    private Long infrastructureId;
    private String infrastructureName;
    private String logo;
}
