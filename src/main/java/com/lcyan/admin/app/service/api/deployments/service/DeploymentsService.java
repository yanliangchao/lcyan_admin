package com.lcyan.admin.app.service.api.deployments.service;

import com.lcyan.admin.app.boot.restultUtils.ResponseDTO;

/**
 * @author Yan Liangchao
 * @version 1.0
 * @date 2020/5/9 9:20
 * @email liangchao.yan-ext@yanfeng.com
 */
public interface DeploymentsService {
    /**
     * 获取全部deployments
     * @param namespaces
     * @return
     */
    ResponseDTO getDeploymentsList(String namespaces);

    /**
     * 创建deployments
     * @param deployments
     * @param namespaces
     * @return
     */
    ResponseDTO createDeployments(String namespaces,String deployments);

    /**
     * 删除deployments
     * @param namespaces
     * @param name
     * @return
     */
    ResponseDTO deleteDeployments(String namespaces, String name);
}
