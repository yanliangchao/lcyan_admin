package com.lcyan.admin.app.boot.handler;

import com.lcyan.admin.app.boot.restultUtils.ResultCodeEnum;
import lombok.Data;

/**
 * @author Yan Liangchao
 * @version 1.0
 * @date 2020/4/20 12:02
 * @email liangchao.yan-ext@yanfeng.com
 */
@Data
public class CMSException extends RuntimeException {
    private Integer code;

    public CMSException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public CMSException(ResultCodeEnum resultCodeEnum) {
        super(resultCodeEnum.getMessage());
        this.code = resultCodeEnum.getCode();
    }

    @Override
    public String toString() {
        return "CMSException{" + "code=" + code + ", message=" + this.getMessage() + '}';
    }
}
