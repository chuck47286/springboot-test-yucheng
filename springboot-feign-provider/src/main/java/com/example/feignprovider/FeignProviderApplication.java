package com.example.feignprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author yucheng
 * @Date 2023/5/26 9:54
 * @Version 1.0
 */
@SpringBootApplication
@EnableSwagger2
public class FeignProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(FeignProviderApplication.class,args);
    }
}
