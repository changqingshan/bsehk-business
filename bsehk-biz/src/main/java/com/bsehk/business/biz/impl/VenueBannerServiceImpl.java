package com.bsehk.business.biz.impl;

import com.bsehk.business.dao.mapper.VenueBannerMapper;
import com.bsehk.business.domain.VenueBanner;
import com.bsehk.business.service.VenueBannerService;
import com.bsehk.business.service.vo.VenueBannerVO;
import com.google.common.annotations.VisibleForTesting;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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

    @Override
    public List<VenueBannerVO> selectBannerByVenueId(Long venueId) {
        List<VenueBannerVO> venueBannerVOList = new ArrayList<VenueBannerVO>();

        List<VenueBanner> venueBanners = venueBannerMapper.selectBannerByVenueId(venueId);
        log.info("venueBanners : [{}]",venueBanners);
        Map<String,List<VenueBanner>> map = venueBanners.parallelStream().collect(Collectors.groupingBy(VenueBanner::getTypeName));
        Set<String> types = map.keySet();
        for (String type:types){
            VenueBannerVO venueBannerVO = new VenueBannerVO();
            venueBannerVO.setType(type);
            venueBannerVO.setVenueBanners(map.get(type));

            venueBannerVOList.add(venueBannerVO);
        }
        return venueBannerVOList;
    }
}
