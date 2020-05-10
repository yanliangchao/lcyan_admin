package com.lcyan.admin.app.service.api.namespaces.controller;

import com.lcyan.admin.app.boot.logging.log.Log;
import com.lcyan.admin.app.boot.restultUtils.ResponseDTO;
import com.lcyan.admin.app.service.api.namespaces.service.NamespacesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author Yan Liangchao
 * @version 1.0
 * @date 2020/5/7 14:06
 * @email liangchao.yan-ext@yanfeng.com
 */
@Api(tags = "API：Namespaces")
@RestController
@RequestMapping("/api/namespaces")
public class NamespacesController {

    @Autowired
    private NamespacesService namespacesService;

    @ApiOperation("获取全部Namespaces")
    @Log("获取全部Namespaces")
    @GetMapping
    @ResponseBody
    public ResponseDTO getNamespacesList(){

        return namespacesService.getNamespacesList();
    }

    @ApiOperation("创建Namespaces")
    @Log("创建Namespaces")
    @PostMapping
    @ResponseBody
    public ResponseDTO createNamespaces(@Validated @RequestBody String namespaces){

        return namespacesService.createNamespaces(namespaces);
    }

    @ApiOperation("删除Namespaces")
    @Log("删除Namespaces")
    @DeleteMapping("{namespaces}")
    @ResponseBody
    public ResponseDTO deleteNamespaces(@PathVariable String namespaces) {

        return namespacesService.deleteNamespaces(namespaces);
    }
}
