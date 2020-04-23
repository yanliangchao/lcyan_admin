package com.lcyan.admin.app.service.admin.controller;


import com.lcyan.admin.app.boot.restultUtils.ResponseDTO;
import com.lcyan.admin.app.service.admin.domain.AdminModel;
import com.lcyan.admin.app.service.admin.service.AdminService;
import io.kubernetes.client.ApiException;
import io.kubernetes.client.apis.CoreV1Api;
import io.kubernetes.client.models.V1PodList;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Api(value = "获取Admin", tags = "AdminController")
@Controller("admin")
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @ApiOperation(value = "获取admin", notes="通过infi获取admin")
    //@ApiImplicitParam(name = "info", value = "字符串", paramType = "query", required = true, dataType = "String")
    @RequestMapping(value = "getAdmin/{info}", method= RequestMethod.GET)
    @ResponseBody
    public ResponseDTO getAdmin(@ApiParam(name = "info", value = "字符串",required = true,defaultValue ="info") @PathVariable("info") String info) {
        //MyUserDetails myUserDetails= (MyUserDetails) SecurityContextHolder.getContext().getAuthentication() .getPrincipal();

        return ResponseDTO.ok().data("info",info).message("获取admin");
    }
    @ApiOperation(value="保存admin", notes="保存Admin")
    @RequestMapping(value="createAdmin", method = RequestMethod.POST)
    @ResponseBody
    public AdminModel createAdmin(@RequestBody AdminModel adminModel){
        System.out.println(adminModel);
        adminModel.setCreateTime(new Date());
        adminModel.setUpdateTime(new Date());
        adminService.saveAdmin(adminModel);
        return adminModel;
    }
    //获取全部pods
    @ApiOperation(value = "获取全部pods", notes="获取全部pods")
    //@ApiImplicitParam(name = "info", value = "字符串", paramType = "query", required = true, dataType = "String")
    @RequestMapping(value = "getAllPods", method= RequestMethod.GET)
    @ResponseBody
    public V1PodList getAllPods() {
        CoreV1Api apiInstance = new CoreV1Api();

        V1PodList v1PodList = null;
        try {
            v1PodList = apiInstance.listPodForAllNamespaces(null, null, null, null, null, null, null, null, null);
        } catch (ApiException e) {
            e.printStackTrace();
        }
        //Gson gson = new Gson();
        //String list = gson.toJson(v1PodList);
        //System.out.println(v1PodList);
        return v1PodList;
    }
}
