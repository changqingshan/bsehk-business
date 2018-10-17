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
        SportCategoryVO sportCategoryVO = new SportCategoryVO();
        List<SportCategoryVO> sportList = new ArrayList<SportCategoryVO>();
        List<SportCategory> childList = new ArrayList<SportCategory>();

        List<SportCategory> sportCategories = sportCategoryMapper.selectAllSport();

        //添加体育类的父类集合
        /*for (SportCategory sportCategory:sportCategories) {
            if(sportCategory.getParentId()==0){
                sportCategoryVO.setId(sportCategory.getId());
                sportCategoryVO.setSportName(sportCategory.getSportName());
                sportCategoryVO.setChildList(childList);
                sportList.add(sportCategoryVO);
                for(SportCategoryVO sportCategoryVO1:sportList){
                    System.out.println(sportCategoryVO1);
                }
            }
        }*/
        for(int i=0;i<sportCategories.size();i++){
            if(sportCategories.get(i).getParentId() == 0){
                sportCategoryVO.setId(sportCategories.get(i).getId());
                sportCategoryVO.setSportName(sportCategories.get(i).getSportName());
                sportCategoryVO.setChildList(childList);
                sportList.add(sportCategoryVO);
                System.out.println(sportCategoryVO);
            }
        }
        //为每个父类添加他的子类集合
        /*for (SportCategoryVO parentSport:sportList) {
            for (SportCategory sportCategory:sportCategories) {
                if (parentSport.getId() == sportCategory.getParentId()){
                    parentSport.getChildList().add(sportCategory);
                }
            }
        }*/
        for (int i=0;i<sportList.size();i++) {
            for (int j=0;j<sportCategories.size();j++) {
                if (sportList.get(i).getId() == sportCategories.get(j).getParentId()){
                    sportList.get(i).getChildList().add(sportCategories.get(j));
                }
            }
        }
        System.out.print("集合++++++++++++++++++"+sportList);
        return sportList;
    }
}
