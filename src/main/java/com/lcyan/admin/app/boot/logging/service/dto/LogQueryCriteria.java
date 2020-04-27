package com.lcyan.admin.app.boot.logging.service.dto;

import com.lcyan.admin.app.boot.common.annotation.Query;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author Yan Liangchao
 * @version 1.0
 * @date 2020/4/20 10:53
 * @email liangchao.yan-ext@yanfeng.com
 */
@Data
public class LogQueryCriteria {

    @Query(blurry = "username,description,address,requestIp,method,params")
    private String blurry;

    @Query
    private String logType;

    @Query(type = Query.Type.BETWEEN)
    private List<Timestamp> createTime;
}
