package com.example.myapplication.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.example.myapplication.config.SentinelConfig;
import com.example.myapplication.config.SentinelParamFlowRuleInit;
import org.springframework.stereotype.Component;

@Component
public class SentinelServiceTest {

//    @SentinelResource(value = "testA", blockHandlerClass = SentinelConfig.class, blockHandler = "handlerExceptionResp", fallbackClass = SentinelConfig.class, fallback = "handlerFallbackResp")
    public int addOneThousand(int id) {
        return id += 1000;
    }
    @SentinelResource(value = "testC")
    public void idAndName(int id, String name) {

    }

    @SentinelResource(value = SentinelParamFlowRuleInit.PARAM_RESOURCE_NAME)
    public void getUserTest(int id, String name) {

    }
}
