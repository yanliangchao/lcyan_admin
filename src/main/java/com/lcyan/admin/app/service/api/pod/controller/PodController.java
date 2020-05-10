package com.lcyan.admin.app.service.api.pod.controller;

import com.lcyan.admin.app.boot.logging.log.Log;
import com.lcyan.admin.app.boot.restultUtils.ResponseDTO;
import com.lcyan.admin.app.service.api.pod.service.PodService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Yan Liangchao
 * @version 1.0
 * @date 2020/4/30 16:03
 * @email liangchao.yan-ext@yanfeng.com
 */
@Api(tags = "API：Pods")
@RestController
@RequestMapping("/api/pods")
public class PodController {

    @Autowired
    private PodService podService;

    @ApiOperation("获取全部pods")
    @Log("获取全部pods")
    @GetMapping("{namespaces}")
    @ResponseBody
    public ResponseDTO getPodList(@PathVariable("namespaces") String namespaces){

        return podService.getPodList(namespaces);
    }

    @ApiOperation("删除pods")
    @Log("删除podspods")
    @DeleteMapping("{namespaces}/{pod}")
    @ResponseBody
    public ResponseDTO deletePod(@PathVariable("namespaces") String namespaces, @PathVariable("pod") String pod){

        return podService.deletePod(namespaces,pod);
    }

}
