package com.lcyan.admin.app.boot.config;

import jdk.internal.instrumentation.Logger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;
/**
 * Demo class
 *
 * @author Liyansong
 * @date 2020/3/3
 */
@Slf4j
@Configuration
public class BootstrapConfig implements ApplicationRunner {

    @Value("${spring.application.name}")
    private String appName;

    @Value("${spring.profiles.active}")
    private String activeProfile;

    @Override
    public void run(final ApplicationArguments args) throws Exception {
        log.info("*******************************************************************");
        log.info("        spring.profiles.active: {} ({})", appName, activeProfile);
        log.info("*******************************************************************");
    }
}
