package com.example.myapplication.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.example.myapplication.config.SentinelConfig;
import com.example.myapplication.config.SentinelParamFlowRuleInit;
import com.example.myapplication.service.MapIteratorService;
import com.example.myapplication.service.SentinelServiceTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class SentinelController {

    @Autowired
    private SentinelServiceTest sentinelServiceTest;

    @Autowired
    private MapIteratorService mapIteratorService;

    @Autowired
    private SentinelParamFlowRuleInit sentinelParamFlowRuleInit;

    private AtomicLong cnt = new AtomicLong(0l);

    @GetMapping("/sentinel")
    public long getCnt() {
        return cnt.getAndSet(0l);
    }

    /**
     * 移除流控
     */
    @GetMapping("/sentinel/removeRate/cnt={cnt}&name={name}")
    public String sentinelRemoveRate(@PathVariable int cnt, @PathVariable String name) {
        sentinelParamFlowRuleInit.removeOrderRateByTechPbu(name, cnt);
        return name + cnt;
    }

    /**
     * 添加 流控
     * @param cnt
     * @param name
     * @return
     */
    @GetMapping("/sentinel/loadRate/cnt={cnt}&name={name}")
    public String sentinelLoadRate(@PathVariable int cnt, @PathVariable String name) {
        sentinelParamFlowRuleInit.loadOrderRateByTechPbu(name, cnt);
        return name + cnt;
    }

    @GetMapping("/sentinel/test/getUser/id={id}&name={name}")
    public int sentinelTestGetUser(@PathVariable int id, @PathVariable String name) {
        sentinelServiceTest.getUserTest(id, name);
        return 40000;
    }

    @GetMapping("/sentinel/test/id={id}&name={name}")
    public int sentinelUserGetTest(@PathVariable int id, @PathVariable String name) {
        System.out.println("[id] : "+ id +" [name] + " + name);
        sentinelServiceTest.idAndName(id, name);
        return 30000;
    }

    @GetMapping("/sentinel/test")
    @SentinelResource(value = "testB", blockHandlerClass = SentinelConfig.class, blockHandler = "handlerExceptionResp", fallbackClass = SentinelConfig.class, fallback = "handlerFallbackResp")
    public int sentinelUserGetTest() {
        cnt.getAndIncrement();
        return 20000;
    }



}
