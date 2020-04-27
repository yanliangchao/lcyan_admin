package com.lcyan.admin.app.service.system.service.dto;

import com.lcyan.admin.app.boot.common.annotation.Query;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author Yan Liangchao
 * @version 1.0
 * @date 2020/4/20 16:35
 * @email liangchao.yan-ext@yanfeng.com
 */
@Data
public class UserQueryCriteria implements Serializable {

    @Query
    private Long id;

    @Query(blurry = "email,username,nickName")
    private String blurry;

    @Query
    private Boolean enabled;


    @Query(type = Query.Type.BETWEEN)
    private List<Timestamp> createTime;
}
