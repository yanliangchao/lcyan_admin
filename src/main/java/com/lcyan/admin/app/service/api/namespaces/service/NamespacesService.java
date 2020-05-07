package com.lcyan.admin.app.service.api.namespaces.service;

import com.lcyan.admin.app.boot.restultUtils.ResponseDTO;

/**
 * @author Yan Liangchao
 * @version 1.0
 * @date 2020/5/7 14:07
 * @email liangchao.yan-ext@yanfeng.com
 */
public interface NamespacesService {
    /**
     * 查询全部namespaces
     * @return
     */
    ResponseDTO getNamespacesList();

    /**
     * 创建namespaces
     * @param namespaces
     * @return
     */
    ResponseDTO createNamespaces(String namespaces);

    /**
     * 删除namespaces
     * @param namespaces
     * @return
     */
    ResponseDTO deleteNamespaces(String namespaces);
}
