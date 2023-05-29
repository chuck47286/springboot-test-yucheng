package com.example.myapplication.config;

import com.alibaba.csp.sentinel.annotation.aspectj.SentinelResourceAspect;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class SentinelConfig {

    @Bean
    public SentinelResourceAspect sentinelResourceAspect() {
        return new SentinelResourceAspect();
    }

//    // 处理 Sentinel 的降级保护逻辑
//    public static int handlerExceptionResp(BlockException ex) {
//        log.info("handlerExceptionResp empty request");
//        return -100;
//    }
//
//
//    // 处理 Sentinel 的降级保护逻辑
//    public static int handlerExceptionResp(int id ,BlockException ex) {
//        log.info("handlerExceptionResp");
//        return -1;
//    }
//    // 处理 Sentinel 的降级保护逻辑
//    public static int handlerExceptionResp(int id, String name, BlockException ex) {
//        log.info("handlerExceptionResp name");
//        return -2;
//    }
//
//    // 处理回退逻辑
//    public static int handlerFallbackResp(int id, Throwable ex) {
//        log.info("handlerFallbackResp");
//        return -3;
//    }

}
