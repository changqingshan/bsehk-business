package com.bsehk.business.web.controller;

import com.bsehk.business.domain.Brand;
import com.bsehk.business.service.BrandService;
import com.bsehk.common.exception.BizException;
import com.bsehk.common.response.ResultData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("/brand")
public class BrandController {
    @Resource
    BrandService brandService;
    /*
     * 查询品牌介绍
     * */
    @RequestMapping("/selectBrand")
    public ResultData selectBrandById(long id){
        Brand brand=brandService.selectBrandById(id);
        if (brand!=null){
            throw new BizException("没有查询到品牌信息");
        }
        return  ResultData.success(brand);
    }
}
