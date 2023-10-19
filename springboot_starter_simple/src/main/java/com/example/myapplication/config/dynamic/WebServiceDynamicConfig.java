//package com.example.myapplication.config.dynamic;
//
//import com.example.myapplication.config.*;
//import lombok.SneakyThrows;
//import org.springframework.beans.MutablePropertyValues;
//import org.springframework.beans.factory.support.BeanDefinitionRegistry;
//import org.springframework.beans.factory.support.RootBeanDefinition;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.context.properties.EnableConfigurationProperties;
//import org.springframework.boot.context.properties.bind.Binder;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.EnvironmentAware;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Import;
//import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
//import org.springframework.core.annotation.AnnotationUtils;
//import org.springframework.core.env.Environment;
//import org.springframework.core.type.AnnotationMetadata;
//
//import java.util.Map;
//import java.util.Objects;
///**
// * @Author yucheng
// * @Date 2023/9/26 8:34
// * @Version 1.0
// */
//@Configuration
//@EnableConfigurationProperties(ConfigProps.class)
//@Import({WebServiceDynamicConfig.ImportConfig.class})
//public class WebServiceDynamicConfig {
//
//    public static class ImportConfig implements ImportBeanDefinitionRegistrar, EnvironmentAware {
//
//        private ConfigProps configProps;
//
//        private ApplicationContext context;
//        private TestBean testBeanthree;
//        public ImportConfig() {
//            context = new AnnotationConfigApplicationContext(TestConfiguration.class);
//            testBeanthree = context.getBean("testBeanFive", TestBean.class);
//        }
//
//
//
//
//        @SneakyThrows
//        @Override
//        public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
//            System.out.println(testBeanthree);
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
//}
