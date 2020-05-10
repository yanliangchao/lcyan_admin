package com.lcyan.admin.app.service.api.deployments.service.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Yan Liangchao
 * @version 1.0
 * @date 2020/5/9 9:30
 * @email liangchao.yan-ext@yanfeng.com
 */
@Data
public class DeploymentsDTO implements Serializable {

    private Long id;
    private String name;
    private String selfLink;
    private String namespaces;
    private Integer replicas;
    private Integer readyReplicas;
    private Integer updatedReplicas;
    private Integer availableReplicas;
    private Integer unavailableReplicas;
    private String selector;
    private String images;
    private String containers;
    private Long age;
}
