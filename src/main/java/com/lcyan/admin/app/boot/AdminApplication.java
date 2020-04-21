package com.lcyan.admin.app.boot;

import com.lcyan.admin.app.boot.webFilter.EnableLogFilter;
import io.kubernetes.client.ApiClient;
import io.kubernetes.client.Configuration;
import io.kubernetes.client.util.ClientBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.lcyan.admin"})
@EnableLogFilter
@EntityScan("com.lcyan.admin.app.service.*.model")
@EnableJpaRepositories("com.lcyan.admin.app.service.*.repository")
public class AdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class, args);
    }
    @Bean
    public void apiClient(){
        ApiClient client = new ClientBuilder().setBasePath("https://172.31.6.164:6443").setVerifyingSsl(false)
                //.setAuthentication(new AccessTokenAuthentication("Token"))
                .build();
        Configuration.setDefaultApiClient(client);
    }
}
