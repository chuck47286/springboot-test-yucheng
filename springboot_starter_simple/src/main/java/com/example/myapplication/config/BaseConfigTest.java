package com.example.myapplication.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @Author yucheng
 * @Date 2023/9/27 14:05
 * @Version 1.0
 */
@Configuration
public class BaseConfigTest {
    @Autowired
    private BaseConfig baseConfig;

    @PostConstruct
    public void init() {
//        System.out.println(baseConfig.getBtsName());
    }
}
