package com.example.myapplication.config.pojo2bean;

import com.example.myapplication.config.BaseBean;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author yucheng
 * @Date 2023/9/27 14:26
 * @Version 1.0
 */
@Component
public class BeanRegistry {
    private Map<String, BaseBean> beanMap;
    private Map<String, BaseBean> basicMap;

    public BeanRegistry() {
        beanMap = new HashMap<>();
        basicMap = new HashMap<>();
        BaseBean baseBean1 = new BaseBean();
        baseBean1.setName("1");
        baseBean1.setAddress("xxx1");
        BaseBean baseBean2 = new BaseBean();
        baseBean2.setName("2");
        baseBean2.setAddress("xxx2");
        BaseBean baseBean3 = new BaseBean();
        baseBean3.setName("3");
        baseBean3.setAddress("xxx3");
        basicMap.put("1", baseBean1);
        basicMap.put("2", baseBean2);
        basicMap.put("3", baseBean3);
    }

    // 添加普通对象到映射中
    public void addBean(String identifier, BaseBean bean) {
        beanMap.put(identifier, bean);
    }

    // 根据标识符获取普通对象
    public BaseBean getBean(String identifier) {
        return beanMap.get(identifier);
    }
    // 获取beanMap
    public Map<String, BaseBean> getBeanMap() {
        return this.beanMap;
    }
    // 获取basicMap
    public Map<String, BaseBean> getBasicMap() {
        return this.basicMap;
    }
}

