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
import java.util.stream.Collectors;

@Service
@Slf4j
public class CityServiceImpl implements CityService {

    @Resource
     private CityMapper cityMapper;

    @Override
    public List<CityVO> getCityTree() {
        List<City> cities = this.cityMapper.listAll((byte) 0);
        if(cities == null || cities.isEmpty()){
            return Collections.emptyList();
        }

        List<CityVO> cityTree = this.createCityTree(cities);

        return cityTree;
    }



    public List<CityVO> createCityTree(List<City> cities){
        List<CityVO> cityVOS = cities.parallelStream().map(city -> CityVO.builder()
                .id(city.getId())
                .name(city.getName())
                .level(city.getLevel())
                .parentId(city.getParentId())
                .children(new ArrayList<>())
                .build())
                .collect(Collectors.toList());

        List<CityVO> roots = new ArrayList<>();

        for(int i=0;i< cityVOS.size();i++){
            CityVO parent = cityVOS.get(i);
            if(parent.getParentId() == 0){
                roots.add(parent);
            }
            int m = 0;
            for(int j=0;j < cityVOS.size();j++){
                CityVO child = cityVOS.get(j);
                if(child.getParentId().equals(parent.getId())){
                    if(m == 1){
                        parent.getChildren().add(0,CityVO.builder().id(-parent.getId()).name("全部").build());
                    }
                    parent.getChildren().add(child);
                    m++;
                }
            }
        }

        return roots;
    }

    @Override
    public List<City> listByIds(List<Long> cityIds) {
        List<City> cities = this.cityMapper.listByIds(cityIds,false);
        return cities;
    }

    @Override
    public List<City> listAll(Boolean isDelete) {
        List<City> cities = this.cityMapper.listAll(isDelete == false ? (byte)0: (byte)1);
        return cities;
    }
}
