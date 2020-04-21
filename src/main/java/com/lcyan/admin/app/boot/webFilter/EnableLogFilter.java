package com.lcyan.admin.app.boot.webFilter;

import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Yan Liangchao
 * @version 1.0
 * @date 2020/4/20 13:53
 * @email liangchao.yan-ext@yanfeng.com
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Import(RequestUrlFilterAutoConfiguration.class)
public @interface EnableLogFilter {
}
