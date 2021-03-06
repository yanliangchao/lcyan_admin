package com.lcyan.admin.app.boot.logging.service.dto;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author Yan Liangchao
 * @version 1.0
 * @date 2020/4/20 10:53
 * @email liangchao.yan-ext@yanfeng.com
 */
@Data
public class LogErrorDTO implements Serializable {

    private Long id;

    private String username;

    private String description;

    private String method;

    private String params;

    private String browser;

    private String requestIp;

    private String address;

    private Timestamp createTime;
}
