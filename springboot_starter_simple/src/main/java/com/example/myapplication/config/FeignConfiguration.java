package com.example.myapplication.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author yucheng
 * @Date 2023/6/8 15:28
 * @Version 1.0
 */
@Configuration
public class FeignConfiguration {
    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
