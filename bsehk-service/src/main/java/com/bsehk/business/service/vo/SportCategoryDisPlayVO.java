package com.bsehk.business.service.vo;

import lombok.Builder;
import lombok.Data;

/**
 * Created by 24398 on 2018/10/25.
 */
@Data
@Builder
public class SportCategoryDisPlayVO {
    private Long sportCategoryId;
    private String sportCategoryName;
    private String logo;

}
