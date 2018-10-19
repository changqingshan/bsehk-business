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
    //获取体育类别的二级页数据
    public List<SportCategoryVO> selectAllSport() {
        List<SportCategoryVO> sportVOList = new ArrayList<SportCategoryVO>();

        //获取所有运动类别
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
             SportCategory sportCategory = new SportCategory();
                sportCategory.setId(-sportVOList.get(i).getId());
                sportCategory.setSportName("全部");
            sportVOList.get(i).getChildList().add(sportCategory);

            for (int j=0;j<sportCategories.size();j++) {
                if (sportVOList.get(i).getId() == sportCategories.get(j).getParentId()){
                    sportVOList.get(i).getChildList().add(sportCategories.get(j));
                }
            }
        }

        return sportVOList;
    }

    @Override
    //获取所有体育类别,父id为0的都是运动大类
    public List<SportCategory> selectParentSport() {
        List<SportCategory> sportCategories = sportCategoryMapper.selectSportByParentId(0L);
        SportCategory sportCategory = new SportCategory();
          sportCategory.setId(null);
          sportCategory.setSportName("全部运动类别");

        sportCategories.add(sportCategory);
        return sportCategories;
    }


    @Override
    public List<SportCategory> listByParentId(Long sportCategoryId) {
        List<SportCategory> sportCategories = this.sportCategoryMapper.listByParentId(sportCategoryId,false);
        return sportCategories;
    }

    @Override
    public SportCategory selectById(Long sportCategoryId) {
        SportCategory sportCategory = this.sportCategoryMapper.selectByPrimaryKey(sportCategoryId);
        return sportCategory;
    }
}
