package com.bsehk.business.biz.impl;

import com.bsehk.business.dao.mapper.SportCategoryDisplayMapper;
import com.bsehk.business.domain.SportCategory;
import com.bsehk.business.domain.SportCategoryDisplay;
import com.bsehk.business.service.SportCategoryDisPlayService;
import com.bsehk.business.service.SportCategoryService;
import com.bsehk.business.service.vo.SportCategoryDisPlayVO;
import com.bsehk.business.service.vo.SportCategoryVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by 24398 on 2018/10/25.
 */

@Service
@Slf4j
public class SportCategoryDisplayServiceImpl implements SportCategoryDisPlayService {

    @Resource
    private SportCategoryDisplayMapper sportCategoryDisplayMapper;
    @Resource
    private SportCategoryService sportCategoryService;

    @Override
    public List<SportCategoryDisPlayVO> listSportCategoryDisplayVO() {
       List<SportCategoryDisplay> sportCategoryDisplays = this.sportCategoryDisplayMapper.listAll(false);
       if(sportCategoryDisplays.isEmpty()){
           return Collections.emptyList();
       }
       // 查找运动类别
        List<Long> sportCategoryIds = sportCategoryDisplays.parallelStream().map(SportCategoryDisplay::getSportCategoryId)
                                                                            .collect(Collectors.toList());

        List<SportCategory> sportCategories = this.sportCategoryService.listByIds(sportCategoryIds,false);

        List<SportCategoryDisPlayVO> sportCategoryDisPlayVOS = sportCategories.parallelStream().map(sportCategory ->
                                              SportCategoryDisPlayVO.builder()
                                                 .sportCategoryId(sportCategory.getId())
                                                 .sportCategoryName(sportCategory.getSportName())
                                                 .logo(sportCategory.getLogo())
                                                 .build())
                                              .collect(Collectors.toList());

        sportCategoryDisPlayVOS.add(SportCategoryDisPlayVO.builder()
                .logo("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=687329704,1284099938&fm=26&gp=0.jpg")
                                               .sportCategoryId(null)
                                               .sportCategoryName("全部项目")
                                               .build());

        return sportCategoryDisPlayVOS;
    }
}
