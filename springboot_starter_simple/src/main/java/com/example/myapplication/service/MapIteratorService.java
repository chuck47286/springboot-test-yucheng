package com.example.myapplication.service;

import com.alibaba.fastjson.JSON;
import com.example.myapplication.infrastructure.OrderQueue;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Slf4j
@Component
public class MapIteratorService {

    @Autowired
    private OrderQueue orderQueue;
    private AtomicLong cnt = new AtomicLong(0l);

    public void iteratorTest() {
        cnt.getAndIncrement();
        int key = RandomUtils.nextInt(0, 80000);
        char c = (char)('a' + RandomUtils.nextInt(0, 26));
        String val = String.valueOf(key) + c;

        List<String> orderQueueList = orderQueue.serialChannelBuffer.getOrDefault(key, new ArrayList<>());
        orderQueueList.add(val);
        orderQueue.serialChannelBuffer.put(key, orderQueueList);
    }

    public String getList() {
        String resp = "";
        int mapStoreItemSize = 0;
        for (Map.Entry<Integer,List<String>> entry : orderQueue.serialChannelBuffer.entrySet()) {
            mapStoreItemSize += entry.getValue().size();
        }
        log.info("[order-Queue-serialChannelBuffer] , size:{}, ItemSizeStoredInMap: {}", orderQueue.serialChannelBuffer.size(), mapStoreItemSize);

        // 统计流量
        resp = resp + cnt.getAndSet(0l) + "times";

        orderQueue.serialChannelBuffer.clear();
        return resp;
    }

}
