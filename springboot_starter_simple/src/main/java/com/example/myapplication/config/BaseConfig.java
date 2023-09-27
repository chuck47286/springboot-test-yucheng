package com.example.myapplication.config;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @Author yucheng
 * @Date 2023/9/27 11:00
 * @Version 1.0
 */
@Slf4j
@Data
@Configuration
public class BaseConfig {
    public static final int NUMBER_ID = 999;

    @Value("${iitp.biz.bts.name}")
    private String btsName;
}
