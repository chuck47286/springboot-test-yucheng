package com.example.myapplication;

import com.example.myapplication.infrastructure.OrderQueue;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Slf4j
@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
@EnableSwagger2
public class Application implements ApplicationRunner {

    @Autowired
    private ApplicationContext context;

    @Autowired
    private OrderQueue orderQueue;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

    }
}