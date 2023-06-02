package com.example.eureka.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author yucheng
 * @Date 2023/5/31 20:30
 * @Version 1.0
 */

@EnableEurekaServer  //开启Eureka 注册中心服务端
@SpringBootApplication
public class EurekaSpringbootApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaSpringbootApplication.class, args);
    }
}
