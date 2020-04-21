package com.lcyan.admin.app.boot.handler;

import com.lcyan.admin.app.boot.restultUtils.ResponseDTO;
import com.lcyan.admin.app.boot.restultUtils.ResultCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpClientErrorException;

/**
 * @author Yan Liangchao
 * @version 1.0
 * @date 2020/4/20 12:04
 * @email liangchao.yan-ext@yanfeng.com
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * -------- 通用异常处理方法 --------
     **/
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseDTO error(Exception e) {
        //e.printStackTrace();
        log.error(ExceptionUtil.getMessage(e));
        return ResponseDTO.error();    // 通用异常结果
    }

    /**
     * -------- 指定异常处理方法 --------
     **/
    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    public ResponseDTO error(NullPointerException e) {
        //e.printStackTrace();
        log.error(ExceptionUtil.getMessage(e));
        return ResponseDTO.setResult(ResultCodeEnum.NULL_POINT);
    }

    @ExceptionHandler(HttpClientErrorException.class)
    @ResponseBody
    public ResponseDTO error(IndexOutOfBoundsException e) {
        //e.printStackTrace();
        log.error(ExceptionUtil.getMessage(e));
        return ResponseDTO.setResult(ResultCodeEnum.HTTP_CLIENT_ERROR);
    }

    /**
     * -------- 自定义定异常处理方法 --------
     **/
    @ExceptionHandler(CMSException.class)
    @ResponseBody
    public ResponseDTO error(CMSException e) {
        //e.printStackTrace();
        log.error(ExceptionUtil.getMessage(e));
        return ResponseDTO.error().message(e.getMessage()).code(e.getCode());
    }
}
