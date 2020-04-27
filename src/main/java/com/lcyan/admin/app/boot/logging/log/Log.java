package com.lcyan.admin.app.boot.logging.log;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Yan Liangchao
 * @version 1.0
 * @date 2020/4/20 10:53
 * @email liangchao.yan-ext@yanfeng.com
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Log {
	String value() default "";
}
