package com.lcyan.admin.app.service.system.service.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;

/**
 * @author Yan Liangchao
 * @version 1.0
 * @date 2020/4/20 16:35
 * @email liangchao.yan-ext@yanfeng.com
 */
@Data
public class UserDto implements Serializable {

    @ApiModelProperty(hidden = true)
    private Long id;

    private String username;

    private String nickName;

    private String sex;

    private String avatar;

    private String email;

    private String phone;

    private Boolean enabled;

    @JsonIgnore
    private String password;

    private Date lastPasswordResetTime;

    @ApiModelProperty(hidden = true)
    private Set<RoleSmallDto> roles;

    private Timestamp createTime;
}
