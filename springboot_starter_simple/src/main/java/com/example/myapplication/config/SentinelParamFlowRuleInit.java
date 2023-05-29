package com.example.myapplication.config;

import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowItem;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowRuleManager;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author yucheng
 * @Date 2023/5/24 10:16
 * @Version 1.0
 */
@Slf4j
@Configuration
public class SentinelParamFlowRuleInit {

    public static final String PARAM_RESOURCE_NAME = "getUserInfo";

    @PostConstruct
    public void init() {
        // 热点数据规则
        List<ParamFlowRule> rules = new ArrayList<>();

        ParamFlowRule paramFlowRule = new ParamFlowRule(SentinelParamFlowRuleInit.PARAM_RESOURCE_NAME)
                .setParamIdx(1)
                .setGrade(RuleConstant.FLOW_GRADE_QPS)
                .setCount(3);

        // 默认所有的第一个参数限制
//        List<ParamFlowItem> paramFlowItemList = new ArrayList<>();
//
//        ParamFlowItem defaultParamFlowItem = new ParamFlowItem()
//                .setObject("")
//                .setClassType(String.class.getName())
//                .setCount(1);


        // 对于具体的参数热点限制



//        paramFlowItemList.add(defaultParamFlowItem);
//        paramFlowRule.setParamFlowItemList(paramFlowItemList);


        rules.add(paramFlowRule);
        ParamFlowRuleManager.loadRules(rules);
    }

    /**
     * 加载techPBU 动态流速权
     * @param techPbu
     * @param cnt
     */
    public void loadOrderRateByTechPbu(String techPbu, int cnt){
        if(StringUtils.isEmpty(techPbu)){
            log.error("Set order rate limit failed, can not find techPbu config. techPbu is null");
            return;
        }

        List<ParamFlowRule> paramFlowRules = new ArrayList<>();
        ParamFlowRule currentParamFlowRule = new ParamFlowRule();
        // 将之前的存在的热点规则替换
        ParamFlowRule oldParamFlowRule = ParamFlowRuleManager.getRules().remove(0);
        List<ParamFlowItem> oldParamFlowItems = oldParamFlowRule.getParamFlowItemList();
        List<ParamFlowItem> currentParamFlowItems = oldParamFlowItems.stream().filter(paramFlowItem -> !techPbu.equals(paramFlowItem.getObject())).collect(Collectors.toList());
        ParamFlowItem newItem = new ParamFlowItem()
                .setObject(techPbu)
                .setClassType(String.class.getName())
                .setCount(cnt);
        currentParamFlowItems.add(newItem);

        currentParamFlowRule.setParamIdx(oldParamFlowRule.getParamIdx());
        currentParamFlowRule.setDurationInSec(oldParamFlowRule.getDurationInSec());
        currentParamFlowRule.setCount(oldParamFlowRule.getCount());
        currentParamFlowRule.setResource(oldParamFlowRule.getResource());
        currentParamFlowRule.setParamFlowItemList(currentParamFlowItems);
        paramFlowRules.add(currentParamFlowRule);

        ParamFlowRuleManager.loadRules(paramFlowRules);
        log.info("current Param flow rule value: {}", paramFlowRules);

    }

    /**
     * 删除 TechPbu 对应的流速权
     * @param techPbu
     */
    public void removeOrderRateByTechPbu(String techPbu, int cnt) {
        if(StringUtils.isEmpty(techPbu)){
            log.info("Remove order rate limit failed, can not find techPbu config. techPbu is null");
            return;
        }

        List<ParamFlowRule> paramFlowRules = new ArrayList<>();
        ParamFlowRule currentParamFlowRule = new ParamFlowRule();
        // 将之前的存在的热点规则替换
        ParamFlowRule oldParamFlowRule = ParamFlowRuleManager.getRules().remove(0);
        List<ParamFlowItem> oldParamFlowItems = oldParamFlowRule.getParamFlowItemList();
        List<ParamFlowItem> currentParamFlowItems = oldParamFlowItems.stream().filter(paramFlowItem -> !techPbu.equals(paramFlowItem.getObject())).collect(Collectors.toList());
        if (cnt >= 0) {
            ParamFlowItem newItem = new ParamFlowItem()
                    .setObject(techPbu)
                    .setClassType(String.class.getName())
                    .setCount(cnt);
            currentParamFlowItems.add(newItem);
        }


        currentParamFlowRule.setParamIdx(oldParamFlowRule.getParamIdx());
        currentParamFlowRule.setDurationInSec(oldParamFlowRule.getDurationInSec());
        currentParamFlowRule.setCount(oldParamFlowRule.getCount());
        currentParamFlowRule.setResource(oldParamFlowRule.getResource());
        currentParamFlowRule.setParamFlowItemList(currentParamFlowItems);
        paramFlowRules.add(currentParamFlowRule);

        ParamFlowRuleManager.loadRules(paramFlowRules);
        log.info("current Param flow rule value: {}", paramFlowRules);
    }
}
