package com.bsehk.business.web.controller;

import com.bsehk.business.domain.VenueProductionGroup;
import com.bsehk.business.service.ProductionService;
import com.bsehk.business.service.VenueProductionGroupService;
import com.bsehk.business.service.vo.ProductionVO;
import com.bsehk.common.response.ResultData;
import com.bsehk.common.util.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by 24398 on 2018/10/26.
 */

@RestController
@Slf4j
public class ProductionController {

    @Resource
    private ProductionService productionService;
    @Resource
    private VenueProductionGroupService venueProductionGroupService;

  @RequestMapping("/production/list")
  public ResultData showProduction(Long venueId, @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                   @RequestParam(value = "pageSize",defaultValue = "15") Integer pageSize){
      PageInfo<List<ProductionVO>> pageInfo = this.productionService.pageProduction(venueId,pageNum,pageSize);
      return ResultData.success(pageInfo);
  }

  @RequestMapping("/production/default/group")
  public ResultData  defaultGroupProduction(Long venueId){
      Map<String,Object>  map = this.venueProductionGroupService.defaultGroupProduction(venueId);
      return ResultData.success(map);
  }


  @RequestMapping("/production/group")
  public ResultData pageGroupProduction(Long venueId,Long venueProductionGroupId,
                                        @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                    @RequestParam(value = "pageSize",defaultValue = "15") Integer pageSize){

      PageInfo<List<ProductionVO>> pageInfo = this.venueProductionGroupService.pageProduction(venueId,venueProductionGroupId,pageNum,pageSize);
      return ResultData.success(pageInfo);
  }


}
