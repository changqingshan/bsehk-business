package com.bsehk.business.biz.impl;

import com.bsehk.business.dao.mapper.SportCategoryMapper;
import com.bsehk.business.domain.SportCategory;
import com.bsehk.business.service.SportCategoryService;
import com.bsehk.business.service.vo.SportCategoryVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class SportCategoryServiceImpl implements SportCategoryService {
    @Resource
    SportCategoryMapper sportCategoryMapper;

    @Override
    public List<SportCategoryVO> selectAllSport() {
        List<SportCategoryVO> sportVOList = new ArrayList<SportCategoryVO>();

        List<SportCategory> sportCategories = sportCategoryMapper.selectAllSport();

        //添加体育类的父类集合
        for (int i=0;i<sportCategories.size();i++){
            if(sportCategories.get(i).getParentId()==0){
                SportCategoryVO sportCategoryVO = new SportCategoryVO();
                sportCategoryVO.setId(sportCategories.get(i).getId());
                sportCategoryVO.setSportName(sportCategories.get(i).getSportName());
                List<SportCategory> childList = new ArrayList<SportCategory>();
                sportCategoryVO.setChildList(childList);
                sportVOList.add(sportCategoryVO);
            }
        }
        //为每个父类添加他的子类集合
        for (int i=0;i<sportVOList.size();i++) {
            for (int j=0;j<sportCategories.size();j++) {
                if (sportVOList.get(i).getId() == sportCategories.get(j).getParentId()){
                    sportVOList.get(i).getChildList().add(sportCategories.get(j));
                }
            }
        }

        return sportVOList;
    }
}
