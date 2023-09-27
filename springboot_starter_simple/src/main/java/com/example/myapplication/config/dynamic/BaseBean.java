package com.example.myapplication.config.dynamic;

import com.example.myapplication.aspect.TimeCostMonitorAnnotation;
import com.example.myapplication.config.MyBean;
import lombok.Data;
import org.springframework.stereotype.Component;

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
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
}
