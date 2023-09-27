package com.example.myapplication.config;

import lombok.Data;

/**
 * @Author yucheng
 * @Date 2023/9/27 13:37
 * @Version 1.0
 */
@Data
public class UserDemo {
    private int id;
    private String name;

    public UserDemo(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
