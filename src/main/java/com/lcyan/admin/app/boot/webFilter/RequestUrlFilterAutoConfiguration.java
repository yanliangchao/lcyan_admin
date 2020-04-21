package com.lcyan.admin.app.boot.webFilter;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Yan Liangchao
 * @version 1.0
 * @date 2020/4/20 13:52
 * @email liangchao.yan-ext@yanfeng.com
 */
@Configuration
@ConditionalOnClass(RequestUrlFilter.class)
public class RequestUrlFilterAutoConfiguration {


    @ConditionalOnMissingBean(RequestUrlFilter.class)
    @Bean
    public FilterRegistrationBean<RequestUrlFilter> requestUrlFilter() {

        FilterRegistrationBean<RequestUrlFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new RequestUrlFilter());
        registrationBean.addUrlPatterns("/*");
        registrationBean.setName("requestUrlFilter");
        registrationBean.setOrder(1);
        return registrationBean;
    }

}
