package com.bsehk.business.service.vo;

import com.bsehk.business.domain.VenueBanner;
import lombok.Data;

import java.util.List;

@Data
public class VenueBannerVO {

    private String type;

    private List<VenueBanner> venueBanners;
}
