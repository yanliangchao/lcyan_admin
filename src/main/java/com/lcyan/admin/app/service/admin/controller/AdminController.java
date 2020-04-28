package com.lcyan.admin.app.service.admin.controller;


import com.lcyan.admin.app.boot.restTemplate.method.Http;
import com.lcyan.admin.app.boot.restultUtils.ResponseDTO;
import com.lcyan.admin.app.service.admin.domain.AdminModel;
import com.lcyan.admin.app.service.admin.service.AdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Api(value = "获取Admin", tags = "AdminController")
@Controller("admin")
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private Http http;

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
    public String getAllPods() {
        ResponseEntity<String> stringResponseEntity = http.get("/", String.class);
        System.out.println(stringResponseEntity.getBody());
        return stringResponseEntity.getBody();
    }
}
