package com.example.myapplication.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfiguration {
//    @Autowired
//    private BaseConfig baseConfig;
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
    @Bean("testBeanthree")
    public TestBean testBeanThree() {
        return new TestBean();
    }

    @Bean("testBeanFive")
    public TestBean testBeanFive() {
//        final int numberId = baseConfig.NUMBER_ID;
        return new TestBean();
    }

//    @Bean("testBeanFour")
//    public TestBean testBeanFour() {
//        final int numberId = baseConfig.NUMBER_ID;
//        return new TestBean();
//    }
}
