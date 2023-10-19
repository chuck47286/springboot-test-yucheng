package com.example.myapplication.controller;

//import com.example.myapplication.config.MyBean;
import com.example.myapplication.config.BaseBean;
import com.example.myapplication.config.MyBean;
import com.example.myapplication.config.TestBeanRequired;
//import com.example.myapplication.config.BaseBean;
//import com.example.myapplication.config.dynamic.WebServiceDynamicConfigFactory;
import com.example.myapplication.config.pojo2bean.BeanRegistry;
import com.netflix.discovery.converters.Auto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Author yucheng
 * @Date 2023/9/22 16:10
 * @Version 1.0
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class BeanController {

    @Autowired
    private TestBeanRequired testBeanRequired;


    // 静态获取bean对象
//    private final MyBean ntsBean;
//    private final MyBean otsBean;
//    private final MyBean btsBean;

//    @Autowired
//    public BeanController(MyBean ntsBean, MyBean otsBean, MyBean btsBean) {
//        this.ntsBean = ntsBean;
//        this.otsBean = otsBean;
//        this.btsBean = btsBean;
//    }
    /**
     * 动态获取bean对象并操作 方法一
     */
//    @Autowired
//    private WebServiceDynamicConfigFactory factory;
    /**
     * 动态获取bean对象并操作 方法二 (failed)
     */
//    @Autowired
//    private CustomBeanRegistrationConfigFactory factory;
    /**
     * 动态获取bean对象并操作 方法三
     */
    @Autowired
    private BeanRegistry beanRegistry;


//    @GetMapping("/bean")
//    public MyBean cntBeanGet() {
//        // 静态获取
////        log.info("nts={}， ots={}, bts={}", JSONUtil.toJsonStr(ntsBean), JSONUtil.toJsonStr(otsBean), JSONUtil.toJsonStr(btsBean));
//        // 动态获取
//        Map<String, BaseBean> mapping = factory.getMapping();
//        final BaseBean nts = mapping.get("nts");
//        final MyBean myBean = new MyBean();
//        myBean.setName("123456");
//        myBean.setAddress("home");
//        MyBean myBeanResult = nts.doSomething("test-", myBean);
//        return myBeanResult;
//    }


//    // 方法二
//    @GetMapping("/bean")
//    public MyBean cntBeanGet() {
//        // 动态获取
//        Map<String, BaseBean> mapping = factory.getMapping();
//        final BaseBean nts = mapping.get("1");
//        final MyBean myBean = new MyBean();
//        myBean.setName("123456");
//        myBean.setAddress("home");
//        MyBean myBeanResult = nts.doSomething("test-", myBean);
//        return myBeanResult;
//    }

    // 方法三
    @GetMapping("/bean")
    public MyBean cntBeanGet() {
        // 动态获取
        Map<String, BaseBean> mapping = beanRegistry.getBeanMap();
        final BaseBean nts = mapping.get("1");
        final MyBean myBean = new MyBean();
        myBean.setName("123456");
        myBean.setAddress("home");
        MyBean myBeanResult = nts.doSomething("test-", myBean);
        return myBeanResult;
    }
}
