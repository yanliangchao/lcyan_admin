package com.lcyan.admin.app.service.system.domain.vo;

import lombok.Data;

/**
 * @author Yan Liangchao
 * @version 1.0
 * @date 2020/4/20 16:35
 * @email liangchao.yan-ext@yanfeng.com
 * 修改密码的Vo类
 */
@Data
public class UserPassVo {

    private String oldPass;

    private String newPass;
}
