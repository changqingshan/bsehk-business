package com.bsehk.business.service.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CoachVO {
    private Long id;
    private String name;
    private String title;
    private String topPhotoUrl;
}
