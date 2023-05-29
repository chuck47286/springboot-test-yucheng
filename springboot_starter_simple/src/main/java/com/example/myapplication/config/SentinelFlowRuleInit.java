//package com.example.myapplication.config;
//
//import com.alibaba.csp.sentinel.slots.block.RuleConstant;
//import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowItem;
//import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowRule;
//import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowRuleManager;
//import org.springframework.context.annotation.Configuration;
//
//import javax.annotation.PostConstruct;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @Author yucheng
// * @Date 2023/5/23 23:24
// * @Version 1.0
// */
//@Configuration
//public class SentinelFlowRuleInit {
//
//    @PostConstruct
//    public void init() {
//        /**
//         * 方式一
//         */
////        // 创建限流规则列表
////        List<FlowRule> rules = new ArrayList<>();
////
////        // 创建限流规则
////        FlowRule rule = new FlowRule();
////        rule.setResource("getUserInfo"); // 设置资源名称
////        rule.setGrade(RuleConstant.FLOW_GRADE_QPS); // 限流模式：QPS
////        rule.setCount(10); // 允许通过的最大请求数量为10
////
////        rules.add(rule);
////
////        // 加载限流规则
////        FlowRuleManager.loadRules(rules);
//        /**
//         * 方式二
//         */
//        // 定义参数热点规则
//        List<ParamFlowRule> rules = new ArrayList<>();
//
//        // 创建规则：参数值为 2 的流量控制规则
//        ParamFlowRule ruleForParamValue2 = new ParamFlowRule("getUserInfo")
//                .setParamIdx(1) // 设置参数索引为 1，对应 name 参数
//                .setGrade(RuleConstant.FLOW_GRADE_QPS) // 限流模式：QPS 模式
//                .setCount(5); // 允许通过的最大请求数量为 5
//
//        // 创建参数项：参数值为 2 的规则
//        List<ParamFlowItem> paramValue2Items = new ArrayList<>();
//        ParamFlowItem paramValue2Item = new ParamFlowItem().setObject("test")
//                .setClassType(String.class.getName())
//                .setCount(2); // 设置 name 参数值为 "test"
//        paramValue2Items.add(paramValue2Item);
//        ruleForParamValue2.setParamFlowItemList(paramValue2Items);
//
////        rules.add(ruleForParamValue2);
//
//        // 创建规则：默认的流量控制规则
////        ParamFlowRule defaultRule = new ParamFlowRule("getUserInfo")
////                .setParamIdx(1) // 设置参数索引为 1，对应 name 参数
////                .setGrade(RuleConstant.FLOW_GRADE_QPS) // 限流模式：QPS 模式
////                .setCount(3); // 允许通过的最大请求数量为 3
//
//        // 设置默认的参数项规则
////        List<ParamFlowItem> defaultItems = new ArrayList<>();
//        ParamFlowItem defaultItem = new ParamFlowItem().setObject("yu")
//                .setClassType(String.class.getName())
//                .setCount(1); // 空参数值，匹配所有其他参数值
////        defaultItems.add(defaultItem);
////        defaultRule.setParamFlowItemList(defaultItems);
////
////        rules.add(defaultRule);
//        paramValue2Items.add(defaultItem);
//        ruleForParamValue2.setParamFlowItemList(paramValue2Items);
//
//        rules.add(ruleForParamValue2);
//
//        // 加载参数热点规则
//        ParamFlowRuleManager.loadRules(rules);
//    }
//}
