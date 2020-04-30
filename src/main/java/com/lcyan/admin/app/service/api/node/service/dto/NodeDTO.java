package com.lcyan.admin.app.service.api.node.service.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Yan Liangchao
 * @version 1.0
 * @date 2020/4/30 10:07
 * @email liangchao.yan-ext@yanfeng.com
 */
@Data
public class NodeDTO implements Serializable {

    private long id;
    private String name;
    private String selfLink;
    private String status;
    private String roles;
    private String version;
    private long age;

    private String internalIp;
    private String hostname;
    private String osImage;
    private String kernelVersion;
    private String cpu;
    private String memory;
    private String containerRuntimeVersion;
    private String podCidr;
}
