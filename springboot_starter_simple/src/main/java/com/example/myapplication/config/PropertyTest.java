package com.example.myapplication.config;

import com.example.myapplication.aspect.TimeCostMonitorAnnotation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PropertyTest {

    @Value("${test.valueA}")
    private String testValueA;

    @TimeCostMonitorAnnotation
    public String getTestValueA() {
        log.info("[test.valueA] {}", testValueA);
        try {
            Thread.sleep(650);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return testValueA;
    }
}
