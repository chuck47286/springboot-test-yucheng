package com.example.myapplication.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class TestConfiguration {

    /**
    @Bean
    public TestBean testBeanOne(TestBeanRequired testBeanRequired) {
        TestBean testBean = new TestBean();
        testBean.setTestBeanRequired(testBeanRequired);
        return testBean;
    }

    @Bean
    public TestBean testBeanTwo() {
        return new TestBean();
    }
     */

    @Bean
    public TestBean testBeanThree() {
        return new TestBean();
    }
}
