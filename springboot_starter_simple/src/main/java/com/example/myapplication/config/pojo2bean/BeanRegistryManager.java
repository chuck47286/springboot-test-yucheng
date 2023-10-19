//package com.example.myapplication.config.pojo2bean;
//
//import com.example.myapplication.config.BaseBean;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.config.ConfigurableBeanFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.support.GenericApplicationContext;
//import org.springframework.stereotype.Component;
//
//import java.util.Map;
//
///**
// * pojo2bean
// * 可以实现将一个pojo对象注册为一个bean对象
// * 并从IOC容器中获取
// * 不过此时的bean对象并没有aop等能力
// * 完成在V2版本
// *
// * @Author yucheng
// * @Date 2023/9/28 13:57
// * @Version 1.0
// */
//@Component
//public class BeanRegistryManager {
//
//    @Autowired
//    private BeanRegistry beanRegistry;
//
//    /**
//     * The Bean factory.
//     */
//    @Autowired
//    private ConfigurableBeanFactory beanFactory;
//
//    /**
//     * The Application context.
//     */
//    @Autowired
//    GenericApplicationContext applicationContext;
//
//    @Bean
//    public void registerBeanManager() {
//        final Map<String, BaseBean> basicMap = beanRegistry.getBasicMap();
//        basicMap.entrySet().forEach(entry -> {
//            beanFactory.registerSingleton(entry.getKey(), entry.getValue());
//        });
//        basicMap.keySet().forEach(key -> {
//            BaseBean bean = applicationContext.getBean(key, BaseBean.class);
//            beanRegistry.addBean(key, bean);
//        });
//
//    }
//}
