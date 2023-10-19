package com.example.myapplication.controller;

import com.example.myapplication.config.BaseBean;
import com.example.myapplication.config.dynamic.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Author yucheng
 * @Date 2023/9/25 18:22
 * @Version 1.0
 */
@RestController
public class MyController {

//    @Autowired
//    private BeanDynamicProperty beanDynamicProperty;

    @Autowired
    private ConfigProps configProps;

//    @Autowired
//    private WebServiceDynamicConfigFactory factory;



//    @GetMapping("/getBeanDynamicProperty/")
//    public String getBeanDynamicProperty() {
//        final Map<String, String> additionalHeaders = beanDynamicProperty.getAdditionalHeaders();
//        System.out.println(additionalHeaders);
//        return "200";
//    }

    @GetMapping("/getConfigProps")
    public String getConfigProps() {
        final Map<String, BaseBean> map = configProps.getBiz();
        System.out.println(map);
        return "200";
    }

//    @GetMapping("/getWebServiceDynamicConfigFactory")
//    public String getWebServiceDynamicConfigFactory() {
//        final Map<String, BaseBean> mapping = factory.getMapping();
//        System.out.println(mapping);
//        return "200";
//    }
}
