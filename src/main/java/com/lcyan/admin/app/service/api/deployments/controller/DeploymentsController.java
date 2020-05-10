package com.lcyan.admin.app.service.api.deployments.controller;

        import com.lcyan.admin.app.boot.logging.log.Log;
        import com.lcyan.admin.app.boot.restultUtils.ResponseDTO;
        import com.lcyan.admin.app.service.api.deployments.service.DeploymentsService;
        import io.swagger.annotations.Api;
        import io.swagger.annotations.ApiOperation;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.validation.annotation.Validated;
        import org.springframework.web.bind.annotation.*;

/**
 * @author Yan Liangchao
 * @version 1.0
 * @date 2020/5/9 9:19
 * @email liangchao.yan-ext@yanfeng.com
 */
@Api(tags = "API：Deployments")
@RestController
@RequestMapping("/api/deployments")
public class DeploymentsController {

    @Autowired
    private DeploymentsService deploymentsService;

    @ApiOperation("获取全部Deployments")
    @Log("获取全部Deployments")
    @GetMapping("{namespaces}")
    @ResponseBody
    public ResponseDTO getDeploymentsList(@PathVariable("namespaces") String namespaces){

        return deploymentsService.getDeploymentsList(namespaces);
    }

    @ApiOperation("创建Deployments")
    @Log("创建Deployments")
    @PostMapping("{namespaces}")
    @ResponseBody
    public ResponseDTO createDeployments(@PathVariable("namespaces") String namespaces, @Validated @RequestBody String deployments){

        return deploymentsService.createDeployments(namespaces,deployments);
    }

    @ApiOperation("删除Deployments")
    @Log("删除Deployments")
    @DeleteMapping("{namespaces}/{name}")
    @ResponseBody
    public ResponseDTO deleteDeployments(@PathVariable("namespaces") String namespaces, @PathVariable("name") String name){

        return deploymentsService.deleteDeployments(namespaces,name);
    }
}
