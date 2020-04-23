package com.lcyan.admin.app.service.system.service.dto;

import com.lcyan.admin.app.boot.common.annotation.Query;
import lombok.Data;

/**
 * @author Zheng Jie
 * 公共查询类
 */
@Data
public class DictQueryCriteria {

    @Query(blurry = "name,remark")
    private String blurry;
}
