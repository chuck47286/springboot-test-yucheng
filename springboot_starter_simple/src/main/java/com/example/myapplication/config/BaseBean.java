package com.example.myapplication.config;

import com.example.myapplication.aspect.TimeCostMonitorAnnotation;
import lombok.Data;

/**
 * @Author yucheng
 * @Date 2023/9/25 18:24
 * @Version 1.0
 */
@Data
public class BaseBean {
    private String address;
    private String name;

    @TimeCostMonitorAnnotation
    public MyBean doSomething(String inputs, MyBean bean) {
        System.out.println(inputs);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return bean;
    }
}
