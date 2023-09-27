//package com.example.myapplication.config.dynamic;
//
//import com.example.myapplication.config.TestBean;
//import lombok.SneakyThrows;
//import org.springframework.beans.MutablePropertyValues;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.support.BeanDefinitionRegistry;
//import org.springframework.beans.factory.support.RootBeanDefinition;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.context.properties.EnableConfigurationProperties;
//import org.springframework.boot.context.properties.bind.Binder;
//import org.springframework.context.EnvironmentAware;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Import;
//import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
//import org.springframework.core.annotation.AnnotationUtils;
//import org.springframework.core.env.Environment;
//import org.springframework.core.type.AnnotationMetadata;
//
//import java.util.Map;
//import java.util.Objects;
//
///**
// * 用于测试如何将一个bean对象注入到内部类中
// *
// * @Author yucheng
// * @Date 2023/9/26 8:34
// * @Version 1.0
// */
//@Configuration
//@EnableConfigurationProperties(ConfigProps.class)
//@Import({ServiceDynamicConfig.class})
////@Import({WebServiceDynamicConfig.class, TestBeanRequired.class})
//public class ServiceDynamicConfig implements ImportBeanDefinitionRegistrar, EnvironmentAware {
//    private ConfigProps configProps;
//
//    @Autowired
//    private TestBean testBean;
//
////    public ServiceDynamicConfig(TestBean testBean) {
////        this.testBean = testBean;
////    }
//
//
//    @SneakyThrows
//    @Override
//    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
//        // test autowired
//        System.out.println(testBean);
//
//        Map<String, BaseBean> mapping = configProps.getBiz();
//        for (Map.Entry<String, BaseBean> entry : configProps.getBiz().entrySet()) {
//            // 注册bean
//            RootBeanDefinition beanDefinition = new RootBeanDefinition();
//            beanDefinition.setBeanClass(BaseBean.class);
//            MutablePropertyValues values = new MutablePropertyValues();
//            values.addPropertyValue("address", entry.getValue().getAddress());
//            values.addPropertyValue("name", entry.getValue().getName());
//            beanDefinition.setPropertyValues(values);
//            beanDefinitionRegistry.registerBeanDefinition(entry.getKey(), beanDefinition);
//        }
//    }
//
//    @Override
//    public void setEnvironment(Environment environment) {
//        // 通过Binder将environment中的值转成对象
//        configProps = Binder.get(environment).bind(getPropertiesPrefix(ConfigProps.class), ConfigProps.class).get();
//    }
//
//    private String getPropertiesPrefix(Class<?> tClass) {
//        return Objects.requireNonNull(AnnotationUtils.getAnnotation(tClass, ConfigurationProperties.class)).prefix();
//    }
//    /**
//    public static class ImportConfig implements ImportBeanDefinitionRegistrar, EnvironmentAware {
//
//
//        private TestBean testBean;
//        public ImportConfig(TestBean testBean) {
//            this.testBean = testBean;
//        }
//
//        private ConfigProps configProps;
//
//        @SneakyThrows
//        @Override
//        public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
//            // test autowired
//            System.out.println(testBean);
//
//            Map<String, BaseBean> mapping = configProps.getBiz();
//            for (Map.Entry<String, BaseBean> entry : configProps.getBiz().entrySet()) {
//                // 注册bean
//                RootBeanDefinition beanDefinition = new RootBeanDefinition();
//                beanDefinition.setBeanClass(BaseBean.class);
//                MutablePropertyValues values = new MutablePropertyValues();
//                values.addPropertyValue("address", entry.getValue().getAddress());
//                values.addPropertyValue("name", entry.getValue().getName());
//                beanDefinition.setPropertyValues(values);
//                beanDefinitionRegistry.registerBeanDefinition(entry.getKey(), beanDefinition);
//            }
//        }
//
//        @Override
//        public void setEnvironment(Environment environment) {
//            // 通过Binder将environment中的值转成对象
//            configProps = Binder.get(environment).bind(getPropertiesPrefix(ConfigProps.class), ConfigProps.class).get();
//        }
//
//        private String getPropertiesPrefix(Class<?> tClass) {
//            return Objects.requireNonNull(AnnotationUtils.getAnnotation(tClass, ConfigurationProperties.class)).prefix();
//        }
//    }
//        */
//}
