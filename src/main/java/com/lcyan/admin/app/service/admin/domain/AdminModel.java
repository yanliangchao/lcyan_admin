package com.lcyan.admin.app.service.admin.domain;


import com.lcyan.admin.app.boot.base.model.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Table(name="t_admin_model")
@Entity
@ApiModel(description = "AdminModel")
public class AdminModel extends BaseModel {

    private static final long serialVersionUID = 6983930123071214565L;

    @ApiModelProperty(value = "username", example = "用户名")
    @Column
    private String username;

    @ApiModelProperty(value = "password", example = "密码")
    @Column
    private String password;
}
