package com.example.myapplication.infrastructure;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

@Component
public class OrderQueue {

    public ThreadPoolExecutor threadPool;

    public ConcurrentHashMap<Integer, List<String>> serialChannelBuffer;
    public Map<Integer, Future> futureMap;

    public OrderQueue() {
        /**
         * 方案一：threadpool 设计指标为
         * 核心线程个数 128
         * 阻塞队列容量为 65536
         */
        threadPool = new ThreadPoolExecutor(128,
                128, 0L, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(1 << 14));
        serialChannelBuffer = new ConcurrentHashMap<>(1 << 16);
        futureMap = new HashMap<>(1 << 16);
    }

}
