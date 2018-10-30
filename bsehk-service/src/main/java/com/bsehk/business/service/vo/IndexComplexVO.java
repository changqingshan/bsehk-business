package com.bsehk.business.service.vo;

import com.bsehk.common.util.PageInfo;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * Created by 24398 on 2018/10/29.
 */
@Data
@Builder
public class IndexComplexVO {


      private List<CityVO> cityVOS;
      private List<SportCategoryDisPlayVO> sportCategoryDisPlayVOS;
      private Long lastLocationId;
      private PageInfo pageInfo;


}
