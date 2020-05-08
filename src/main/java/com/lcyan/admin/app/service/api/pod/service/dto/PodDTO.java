package com.lcyan.admin.app.service.api.pod.service.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Yan Liangchao
 * @version 1.0
 * @date 2020/5/6 9:44
 * @email liangchao.yan-ext@yanfeng.com
 */
@Data
public class PodDTO implements Serializable {

    private Long id;
    private String name;
    private String selfLink;
    private String node;
    private String status;
    private String restarts;
    private String images;
    private Long age;
}
