package com.bsehk.business.web.controller;

import com.bsehk.business.service.SportCategoryService;
import com.bsehk.business.service.vo.SportCategoryVO;
import com.bsehk.common.exception.BizException;
import com.bsehk.common.response.ResultData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/sport")
public class SportCategoryController {

    @Resource
    SportCategoryService sportCategoryService;

    /*
    * 查询所有运动类别
    * */
    @RequestMapping("/selectAllSport")
    public ResultData selectAllSport(){
        List<SportCategoryVO> sportCategoryVOList = sportCategoryService.selectAllSport();
        if(sportCategoryVOList.size()==0){
            throw new BizException("没有找到体育类");
        }
        return ResultData.success(sportCategoryVOList);
    }


}
