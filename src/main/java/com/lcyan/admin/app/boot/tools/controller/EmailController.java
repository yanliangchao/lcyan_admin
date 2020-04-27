package com.lcyan.admin.app.boot.tools.controller;

import com.lcyan.admin.app.boot.logging.log.Log;
import com.lcyan.admin.app.boot.tools.domain.EmailConfig;
import com.lcyan.admin.app.boot.tools.domain.vo.EmailVo;
import com.lcyan.admin.app.boot.tools.service.EmailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author Yan Liangchao
 * @version 1.0
 * @date 2020/4/20 16:35
 * @email liangchao.yan-ext@yanfeng.com
 */
@RestController
@RequestMapping("api/email")
@Api(tags = "工具：邮件管理")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @GetMapping
    public ResponseEntity<Object> get(){
        return new ResponseEntity<>(emailService.find(), HttpStatus.OK);
    }

    @Log("配置邮件")
    @PutMapping
    @ApiOperation("配置邮件")
    public ResponseEntity<Object> emailConfig(@Validated @RequestBody EmailConfig emailConfig){
        emailService.update(emailConfig,emailService.find());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Log("发送邮件")
    @PostMapping
    @ApiOperation("发送邮件")
    public ResponseEntity<Object> send(@Validated @RequestBody EmailVo emailVo) throws Exception {
        emailService.send(emailVo,emailService.find());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
