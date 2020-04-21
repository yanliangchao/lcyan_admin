package com.lcyan.admin.app.boot.restultUtils;

import lombok.Getter;

/**
 * @author Yan Liangchao
 * @version 1.0
 * @date 2020/4/20 10:53
 * @email liangchao.yan-ext@yanfeng.com
 */
@Getter
public enum ResultCodeEnum {
    SUCCESS("SUCCESS",200,"成功"),
    UNKNOWN_ERROR("UNKNOWN_ERROR",500,"未知错误"),
    NULL_POINT("NULL_POINT",400,"空指针异常"),
    HTTP_CLIENT_ERROR("HTTP_CLIENT_ERROR",400,"请求错误"),
    PARAM_ERROR("PARAM_ERROR",400,"参数错误");

    // 响应是否成功
    private String status;
    // 响应状态码
    private Integer code;
    // 响应信息
    private String message;

    ResultCodeEnum(String status, Integer code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }
}
