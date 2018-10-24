package com.bsehk.business.biz.impl;

import com.bsehk.business.dao.mapper.VenueBannerMapper;
import com.bsehk.business.domain.VenueBanner;
import com.bsehk.business.domain.VenueBannerCategory;
import com.bsehk.business.service.VenueBannerCategoryService;
import com.bsehk.business.service.VenueBannerService;
import com.bsehk.business.service.vo.VenueBannerVO;
import com.google.common.annotations.VisibleForTesting;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ChoiceFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
public class VenueBannerServiceImpl implements VenueBannerService {
    @Resource
    VenueBannerMapper venueBannerMapper;
    @Resource
    private VenueBannerCategoryService venueBannerCategoryService;


    @Override
    public List<VenueBannerVO> selectBannerByVenueId(Long venueId) {

        List<VenueBannerVO> venueBannerVOList = new ArrayList<VenueBannerVO>();

        List<VenueBanner> venueBanners = venueBannerMapper.selectBannerByVenueId(venueId,false);
        Map<Long,List<VenueBanner>> map = venueBanners.parallelStream().collect(Collectors.groupingBy(VenueBanner::getVenueBannerCategoryId));
        // 查询对应类别
        List<Long> venueBannerCategoryIds = venueBanners.parallelStream().map(VenueBanner::getVenueBannerCategoryId).distinct().collect(Collectors.toList());
        List<VenueBannerCategory> venueBannerCategories = this.venueBannerCategoryService.listByIds(venueBannerCategoryIds,false);
        Map<Long,String> venueBannerCategoryMap = venueBannerCategories.parallelStream()
                                             .collect(Collectors.toMap(VenueBannerCategory::getId,VenueBannerCategory::getCategoryName));
        map.forEach((k,v) ->{
            VenueBannerVO venueBannerVO = VenueBannerVO.builder()
                                                       .typeName(venueBannerCategoryMap.get(k))
                                                       .venueBanners(v)
                                                       .build();
            venueBannerVOList.add(venueBannerVO);
        });
        return venueBannerVOList;
    }


    @Override
    public Integer numberBanner(Long venueId, Boolean isDelete) {

        Integer number = this.venueBannerMapper.numberBanner(venueId,isDelete);
        return number;
    }
}
