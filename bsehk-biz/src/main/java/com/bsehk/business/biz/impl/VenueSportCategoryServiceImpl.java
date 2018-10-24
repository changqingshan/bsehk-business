package com.bsehk.business.biz.impl;

import com.bsehk.business.dao.mapper.VenueSportCategoryMapper;
import com.bsehk.business.domain.VenueSport;
import com.bsehk.business.domain.VenueSportCategory;
import com.bsehk.business.service.VenueSportCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class VenueSportCategoryServiceImpl implements VenueSportCategoryService {

    @Resource
    private VenueSportCategoryMapper venueSportCategoryMapper;

    @Override
    public List<VenueSport> listVenueSport(List<Long> venueIds,Boolean isDelete) {
        List<VenueSport> venueSports = this.venueSportCategoryMapper.listVenueSport(venueIds,isDelete);
        return venueSports;
    }


    @Override
    public VenueSportCategory selectById(Long id) {
        VenueSportCategory venueSportCategory = this.venueSportCategoryMapper.selectByPrimaryKey(1L);
        return venueSportCategory;
    }
}
