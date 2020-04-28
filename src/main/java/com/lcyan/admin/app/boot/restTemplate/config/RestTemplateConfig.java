package com.lcyan.admin.app.boot.restTemplate.config;

/**
 * @author Yan Liangchao
 * @version 1.0
 * @date 2020/4/27 16:54
 * @email liangchao.yan-ext@yanfeng.com
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate restTemplate(ClientHttpRequestFactory factory){

        return new RestTemplate(factory);
    }

    @Bean
    public ClientHttpRequestFactory HttpsClientRequestFactory(){
        HttpsClientRequestFactory factory = new HttpsClientRequestFactory();
        factory.setReadTimeout(5000);//单位为ms
        factory.setConnectTimeout(5000);//单位为ms
        return factory;
    }
}
