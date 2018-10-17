package com.bsehk.business.service.vo;

import com.bsehk.business.domain.SportCategory;
import lombok.Data;

import java.util.List;

@Data
public class SportCategoryVO {
    private Long id;

    private String sportName;

    private List<SportCategory> childList;  //体育类子对象集合
}
