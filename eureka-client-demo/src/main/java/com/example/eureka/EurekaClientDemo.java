package com.example.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author yucheng
 * @Date 2023/6/6 17:20
 * @Version 1.0
 */
@EnableEurekaClient
@SpringBootApplication
public class EurekaClientDemo {
    public static void main(String[] args) {
        SpringApplication.run(EurekaClientDemo.class, args);
    }
}
