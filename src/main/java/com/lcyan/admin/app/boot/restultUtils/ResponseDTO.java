package com.lcyan.admin.app.boot.restultUtils;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Yan Liangchao
 * @version 1.0
 * @date 2020/4/20 10:39
 * @email liangchao.yan-ext@yanfeng.com
 */
@Data
public class ResponseDTO {
    private String status;

    private Integer code;

    private String message;

    private Map<String, Object> data = new HashMap<>();

    // 构造器私有
    private ResponseDTO(){}

    // 通用返回成功
    public static ResponseDTO ok() {
        ResponseDTO r = new ResponseDTO();
        r.setStatus(ResultCodeEnum.SUCCESS.getStatus());
        r.setCode(ResultCodeEnum.SUCCESS.getCode());
        r.setMessage(ResultCodeEnum.SUCCESS.getMessage());
        return r;
    }

    // 通用返回失败，未知错误
    public static ResponseDTO error() {
        ResponseDTO r = new ResponseDTO();
        r.setStatus(ResultCodeEnum.UNKNOWN_ERROR.getStatus());
        r.setCode(ResultCodeEnum.UNKNOWN_ERROR.getCode());
        r.setMessage(ResultCodeEnum.UNKNOWN_ERROR.getMessage());
        return r;
    }

    // 设置结果，形参为结果枚举
    public static ResponseDTO setResult(ResultCodeEnum result) {
        ResponseDTO r = new ResponseDTO();
        r.setStatus(result.getStatus());
        r.setCode(result.getCode());
        r.setMessage(result.getMessage());
        return r;
    }

    /**------------使用链式编程，返回类本身-----------**/

    // 自定义返回数据
    public ResponseDTO data(Map<String,Object> map) {
        this.setData(map);
        return this;
    }

    // 通用设置data
    public ResponseDTO data(String key,Object value) {
        this.data.put(key, value);
        return this;
    }

    // 自定义状态信息
    public ResponseDTO message(String message) {
        this.setMessage(message);
        return this;
    }

    // 自定义状态码
    public ResponseDTO code(Integer code) {
        this.setCode(code);
        return this;
    }

    // 自定义返回结果
    public ResponseDTO success(String result) {
        this.setStatus(result);
        return this;
    }
}
