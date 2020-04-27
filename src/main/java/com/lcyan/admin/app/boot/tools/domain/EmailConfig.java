package com.lcyan.admin.app.boot.tools.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author Yan Liangchao
 * @version 1.0
 * @date 2020/4/20 16:35
 * @email liangchao.yan-ext@yanfeng.com
 */
@Entity
@Data
@Table(name = "t_email_config")
public class EmailConfig implements Serializable {

    @Id
    private Long id;

    /** 邮件服务器SMTP地址 */
    @NotBlank
    private String host;

    /** 邮件服务器 SMTP 端口 */
    @NotBlank
    private String port;

    /** 发件者用户名，默认为发件人邮箱前缀 */
    @NotBlank
    private String user;

    @NotBlank
    private String pass;

    /** 收件人 */
    @NotBlank
    @Column(name = "from_user")
    private String fromUser;
}
