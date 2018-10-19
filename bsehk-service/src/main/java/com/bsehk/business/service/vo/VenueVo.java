package com.bsehk.business.service.vo;

import com.bsehk.business.domain.FunctionZone;
import com.bsehk.business.domain.Infrastructure;
import com.bsehk.business.domain.Venue;
import lombok.Data;

import java.util.List;
@Data
public class VenueVo {
private long id;
private Venue venue;
private List<String> sportList;//运动标签
private List<Infrastructure> infrastructuresList;//场馆基础信息
private List<FunctionZone>  functionZoneList;//功能区集合
}
