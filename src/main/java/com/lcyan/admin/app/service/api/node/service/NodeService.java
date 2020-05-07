package com.lcyan.admin.app.service.api.node.service;

import com.lcyan.admin.app.boot.restultUtils.ResponseDTO;

/**
 * @author Yan Liangchao
 * @version 1.0
 * @date 2020/4/30 8:53
 * @email liangchao.yan-ext@yanfeng.com
 */
public interface NodeService {

    /**
     * 查询全部Node
     * @return
     */
    ResponseDTO getNodeList();

    /**
     * 查询node详细信息
     * @param selfLink
     * @return
     */
    ResponseDTO getNode(String selfLink);
}
