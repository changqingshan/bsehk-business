package com.bsehk.business.service.vo;

import com.bsehk.business.domain.CoachMedia;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CoachVO {
    private Long id;
    private String name;                    //姓名
    private String title;                   //职称
    private String topPhotoUrl;             //首页照片
    private String intro;                   //简介
    private List<CoachMedia> photoList;            //照片
    private List<CoachMedia> shortVideoList;        //15s短视频
    private List<CoachMedia> longVideoList;         //长视频
    private List<CoachMedia> qualificationList; //资质证明
}
