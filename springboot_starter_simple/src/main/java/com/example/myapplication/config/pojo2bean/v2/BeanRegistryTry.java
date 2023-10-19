package com.example.myapplication.config.pojo2bean.v2;

import com.example.myapplication.config.BaseBean;
import com.example.myapplication.config.pojo2bean.BeanRegistry;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 这是一个正常将一个普通的pojo对象转换为bean对象
 * 这是由于利用了Spring的注册bean定义，而不是注册bean对象
 * 所以，bean对象具有aop等能力
 *
 *
 * @Author yucheng
 * @Date 2023/9/28 14:35
 * @Version 1.0
 */
@Component
public class BeanRegistryTry {
    @Autowired
    private BeanRegistry beanRegistry;

    /**
     * The Application context.
     */
    @Autowired
    private GenericApplicationContext applicationContext;

    @Bean
    public void BeanRegistryTry() {
        Map<String, BaseBean> basicMap = beanRegistry.getBasicMap();
        basicMap.entrySet().forEach(entry -> {
            GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
            beanDefinition.setBeanClass(entry.getValue().getClass());
            MutablePropertyValues propertyValues = new MutablePropertyValues();
            propertyValues.add("address", entry.getValue().getAddress());
            propertyValues.add("name", entry.getValue().getName());
            beanDefinition.setPropertyValues(propertyValues);
            applicationContext.registerBeanDefinition(entry.getKey(), beanDefinition);
        });

        basicMap.keySet().forEach(key -> {
            BaseBean bean = applicationContext.getBean(key, BaseBean.class);
            beanRegistry.addBean(key, bean);
        });

    }
}
