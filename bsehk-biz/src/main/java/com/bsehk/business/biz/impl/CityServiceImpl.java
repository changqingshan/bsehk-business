package com.bsehk.business.biz.impl;

import com.bsehk.business.dao.mapper.CityMapper;
import com.bsehk.business.domain.City;
import com.bsehk.business.service.CityService;
import com.bsehk.business.service.vo.CityVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@Slf4j
public class CityServiceImpl implements CityService {

    @Resource
     private CityMapper cityMapper;

    @Override
    public List<CityVO> listCity() {
        List<City> cities = this.cityMapper.listAll((byte) 0);
        if(cities == null || cities.isEmpty()){
            return Collections.emptyList();
        }
        List<CityVO> cityVOS = new ArrayList<>();
        cities.forEach(city -> {
            if(city.getParentId() == 0){
                // 省
                CityVO cityVO = CityVO.builder().id(city.getId())
                                                .name(city.getName())
                                                .children(new ArrayList<>())
                                                .build();
                cityVOS.add(cityVO);
            }
        });

        for(int i =0;i<cityVOS.size();i++){
            CityVO cityVO = cityVOS.get(i);
            cityVO.getChildren().add(CityVO.builder().id(-cityVO.getId()).name("全部").build());

            cities.forEach(city -> {
                if(cityVO.getId().equals(city.getParentId())){
                    CityVO child = CityVO.builder().id(city.getId()).name(city.getName()).build();
                    cityVO.getChildren().add(child);
                } });
        }
        return cityVOS;
    }


    @Override
    public List<City> listByIds(List<Long> cityIds) {
        List<City> cities = this.cityMapper.listByIds(cityIds,false);
        return cities;
    }
}
