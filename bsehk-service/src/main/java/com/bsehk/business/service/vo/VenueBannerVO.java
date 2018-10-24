package com.bsehk.business.service.vo;

import com.bsehk.business.domain.VenueBanner;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class VenueBannerVO {

    private String typeName;

    private List<VenueBanner> venueBanners;
}
