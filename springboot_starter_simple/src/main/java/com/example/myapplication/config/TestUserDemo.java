package com.example.myapplication.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author yucheng
 * @Date 2023/9/27 13:38
 * @Version 1.0
 */
@Configuration
public class TestUserDemo {

    private Map<String, UserDemo> user_map;

    public TestUserDemo() {
        user_map = new HashMap<>();
        user_map.put("Bob", new UserDemo(1, "Bob"));
        user_map.put("Tom", new UserDemo(2, "Tom"));
        user_map.put("Jerry", new UserDemo(3, "Jerry"));

        System.out.println(user_map);
    }

//    public void init() {
//        user_map = new HashMap<>();
//        user_map.put("Bob", new UserDemo(1, "Bob"));
//        user_map.put("Tom", new UserDemo(2, "Tom"));
//        user_map.put("Jerry", new UserDemo(3, "Jerry"));
//    }
}
