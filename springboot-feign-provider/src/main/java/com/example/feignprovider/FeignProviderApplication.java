package com.example.feignprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author yucheng
 * @Date 2023/5/26 9:54
 * @Version 1.0
 */

@EnableEurekaClient
@SpringBootApplication
@EnableSwagger2
public class FeignProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(FeignProviderApplication.class,args);
    }
}
