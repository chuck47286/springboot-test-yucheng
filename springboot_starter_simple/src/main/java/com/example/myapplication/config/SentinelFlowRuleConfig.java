//package com.example.myapplication.config;
//
//import cn.hutool.core.io.file.FileWriter;
//import com.alibaba.csp.sentinel.datasource.*;
//import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
//import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
//import com.alibaba.csp.sentinel.transport.util.WritableDataSourceRegistry;
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.TypeReference;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.InitializingBean;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.List;
//
//@Slf4j
//@Component
//public class SentinelFlowRuleConfig implements InitializingBean {
//
//    @Value("${sentinel.flow.rule}")
//    private String sentinelFlowRule;
//
//    @Override
//    public void afterPropertiesSet() throws Exception {
//        String ruleDir = "/home/rules";
//
//        String flowRulePath = ruleDir + "/flow_rule.json";
//
//        this.mkdirIfNotExists(ruleDir);
//        this.createFileIfNotExists(flowRulePath);
//        try {
//            FileWriter fileWriter = FileWriter.create(new File(flowRulePath));
//            log.info("写入限流规则rule: {}", sentinelFlowRule);
//            fileWriter.write(sentinelFlowRule);
//        } catch (Exception e) {
//            log.warn("写入限流配置规则失败，[err-message] {}", e.getMessage());
//        }
//
//        ReadableDataSource<String, List<FlowRule>> flowRuleRDS = new FileRefreshableDataSource<>(
//                flowRulePath,
//                flowRuleListParser
//        );
//        FlowRuleManager.register2Property(flowRuleRDS.getProperty());
//
//        WritableDataSource<List<FlowRule>> flowRuleWDS = new FileWritableDataSource<>(
//                flowRulePath,
//                this::encodeJson
//        );
//        WritableDataSourceRegistry.registerFlowDataSource(flowRuleWDS);
//
//
//
//    }
//
//    private void mkdirIfNotExists(String dirPath) {
//        File file = new File(dirPath);
//        if (!file.exists()) {
//            file.mkdirs();
//        }
//    }
//
//    private void createFileIfNotExists(String filePath) throws IOException {
//        File file  = new File(filePath);
//        if (!file.exists()) {
//            file.createNewFile();
//        }
//    }
//
//
//    private <T> String encodeJson(T t) {
//        return JSON.toJSONString(t);
//    }
//
//    private Converter<String, List<FlowRule>> flowRuleListParser = source -> JSON.parseObject(
//            source,
//            new TypeReference<List<FlowRule>>(){}
//    );
//}
