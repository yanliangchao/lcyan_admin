package com.lcyan.admin.app.service.api.node.controller;

import com.lcyan.admin.app.boot.logging.log.Log;
import com.lcyan.admin.app.boot.restultUtils.ResponseDTO;
import com.lcyan.admin.app.service.api.node.service.NodeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Yan Liangchao
 * @version 1.0
 * @date 2020/4/30 8:43
 * @email liangchao.yan-ext@yanfeng.com
 */
@Api(tags = "API：Nodes")
@RestController
@RequestMapping("/api/nodes")
public class NodeController {

    @Autowired
    private NodeService nodeService;

    @ApiOperation("获取全部Nodes")
    @Log("获取全部Nodes")
    @GetMapping
    @ResponseBody
    public ResponseDTO getNode(){

        return nodeService.getNode();
    }
}
