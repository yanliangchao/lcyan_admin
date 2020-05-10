package com.lcyan.admin.app.service.api.pod.service;

import com.lcyan.admin.app.boot.restultUtils.ResponseDTO;

/**
 * @author Yan Liangchao
 * @version 1.0
 * @date 2020/4/30 16:11
 * @email liangchao.yan-ext@yanfeng.com
 */
public interface PodService {

    /**
     * 获取全部pods
     * @param namespaces
     * @return
     */
    ResponseDTO getPodList(String namespaces);

    /**
     * 删除pods
     * @param namespaces
     * @param pod
     * @return
     */
    ResponseDTO deletePod(String namespaces, String pod);
}
