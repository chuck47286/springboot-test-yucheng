//package com.example.myapplication.config.dynamic;
//
//import com.example.myapplication.config.BaseBean;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Set;
//
///**
// * @Author yucheng
// * @Date 2023/9/26 8:48
// * @Version 1.0
// */
//@Configuration
//public class WebServiceDynamicConfigFactory {
//    @Autowired
//    private ConfigProps configProps;
//
//    @Autowired
//    private ApplicationContext applicationContext;
//    private Map<String, BaseBean> mapping;
//    public WebServiceDynamicConfigFactory() {
//        mapping = new HashMap<>();
//    }
//
//    public Map<String, BaseBean> getMapping() {
//        return this.mapping;
//    }
//
//    @Bean
//    public void createMyBean() {
//        Set<String> strings = configProps.getBiz().keySet();
//        strings.forEach(key -> {
//            BaseBean bean = applicationContext.getBean(key, BaseBean.class);
//            mapping.put(key, bean);
//        });
//
//    }
//}
