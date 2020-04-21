package com.lcyan.admin.app.boot.base.model;

import lombok.Data;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Yan Liangchao
 * @version 1.0
 * @date 2020/4/20 16:20
 * @email liangchao.yan-ext@yanfeng.com
 */

@Data
@MappedSuperclass
public class BaseModel implements Serializable {

 private static final long serialVersionUID = -219630988791392777L;
 @Id
 @GeneratedValue
 @Nullable
 private Long id;

 @Column
 @Temporal(TemporalType.TIMESTAMP)
 private Date createTime;

 @Column
 @Temporal(TemporalType.TIMESTAMP)
 private Date updateTime;

}
