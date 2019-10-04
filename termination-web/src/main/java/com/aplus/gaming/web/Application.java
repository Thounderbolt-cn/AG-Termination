package com.aplus.gaming.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 启动类
 *
 * @author Javis
 * @date 2019年6月17日08:35:24
 */
@EnableAsync
@EnableScheduling
@SpringBootApplication(scanBasePackages = {"com.aplus.gaming"})
@PropertySource(value = "classpath:config/biz-config.properties")
public class Application {

    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        SpringApplication.run(Application.class, args);
        System.out.println("Server startup expense time:" + (System.currentTimeMillis() - start) + "ms.");
    }
}
