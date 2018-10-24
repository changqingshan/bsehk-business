package com.bsehk.business.biz.impl;

import com.bsehk.business.dao.mapper.FunctionZoneMapper;
import com.bsehk.business.domain.FunctionZone;
import com.bsehk.business.service.FunctionZoneService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

@Service
@Slf4j
public class FunctionZoneServiceImpl implements FunctionZoneService {

    @Resource
    private FunctionZoneMapper functionZoneMapper;

    @Override
    public List<FunctionZone> listByIds(List<Long> functionZoneIds, Boolean isDelete) {
        if(functionZoneIds == null || functionZoneIds.isEmpty()){
            return Collections.emptyList();
        }
        List<FunctionZone> functionZones = this.functionZoneMapper.listByIds(functionZoneIds,false);
        return functionZones;
    }
}
