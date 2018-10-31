package com.bsehk.business.web.controller;

import com.bsehk.business.service.CityService;
import com.bsehk.business.service.vo.CityVO;
import com.bsehk.common.response.ResultData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 24398 on 2018/10/25.
 */
@RestController
@Slf4j
public class CityController {

    @Resource
    private CityService cityService;

    @RequestMapping("/city/tree")
    public ResultData getCityTree(){
        List<CityVO> cityTree = cityService.getCityTree();
        return ResultData.success(cityTree);
    }

}
