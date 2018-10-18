package com.bsehk.business.service;

import com.bsehk.business.domain.City;
import com.bsehk.business.service.vo.CityVO;

import java.util.List;

public interface CityService {

    List<CityVO>  listCity();

    List<City> listByIds(List<Long> cityIds);
}
