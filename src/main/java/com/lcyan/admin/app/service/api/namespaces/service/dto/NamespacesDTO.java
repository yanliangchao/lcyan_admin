package com.lcyan.admin.app.service.api.namespaces.service.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Yan Liangchao
 * @version 1.0
 * @date 2020/5/7 14:08
 * @email liangchao.yan-ext@yanfeng.com
 */
@Data
public class NamespacesDTO implements Serializable {

    private Long id;
    private String name;
    private String status;
}
