package com.imalvisc.apollo.registrar;

import com.ctrip.framework.apollo.spring.annotation.ApolloAnnotationProcessor;
import com.ctrip.framework.apollo.spring.annotation.ApolloJsonValueProcessor;
import com.ctrip.framework.apollo.spring.annotation.SpringValueProcessor;
import com.ctrip.framework.apollo.spring.config.PropertySourcesProcessor;
import com.ctrip.framework.apollo.spring.property.SpringValueDefinitionProcessor;
import com.ctrip.framework.apollo.spring.util.BeanRegistrationUtil;
import com.google.common.collect.Lists;
import com.imalvisc.apollo.annotation.EnableCustomApolloConfig;
import com.imalvisc.apollo.config.Namespaces;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;

import java.util.HashMap;
import java.util.Map;

/**
 * @author imalvisc
 * @version v1.0
 * @ClassName CustomApolloRegistrar
 * @Description 自定义Apollo注解器
 * @motto 学会编程而不是学会编码！
 * @date 2019-06-04 20:48
 * @Copyright Guangzhou CheXingYi Information Technology Co., Ltd.
 */
public class CustomApolloConfigRegistrar implements ImportBeanDefinitionRegistrar {

    /**
     * 注册Apollo核心Bean, 模仿Apollo原生代码
     *
     * @param importingClassMetadata
     * @param registry
     */
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        AnnotationAttributes attributes = AnnotationAttributes.fromMap(importingClassMetadata.getAnnotationAttributes(EnableCustomApolloConfig.class.getName()));
        assert attributes != null;
        String[] namespaces = attributes.getStringArray("value");
        this.storeNamespaces(namespaces);
        int order = attributes.getNumber("order");
        PropertySourcesProcessor.addNamespaces(Lists.newArrayList(namespaces), order);
        Map<String, Object> propertySourcesPlaceholderPropertyValues = new HashMap();
        propertySourcesPlaceholderPropertyValues.put("order", 0);
        BeanRegistrationUtil.registerBeanDefinitionIfNotExists(registry, PropertySourcesPlaceholderConfigurer.class.getName(), PropertySourcesPlaceholderConfigurer.class, propertySourcesPlaceholderPropertyValues);
        BeanRegistrationUtil.registerBeanDefinitionIfNotExists(registry, PropertySourcesProcessor.class.getName(), PropertySourcesProcessor.class);
        BeanRegistrationUtil.registerBeanDefinitionIfNotExists(registry, ApolloAnnotationProcessor.class.getName(), ApolloAnnotationProcessor.class);
        BeanRegistrationUtil.registerBeanDefinitionIfNotExists(registry, SpringValueProcessor.class.getName(), SpringValueProcessor.class);
        BeanRegistrationUtil.registerBeanDefinitionIfNotExists(registry, SpringValueDefinitionProcessor.class.getName(), SpringValueDefinitionProcessor.class);
        BeanRegistrationUtil.registerBeanDefinitionIfNotExists(registry, ApolloJsonValueProcessor.class.getName(), ApolloJsonValueProcessor.class);
    }

    /**
     * 将命令空间保存起来, 供刷新监听器动态使用
     *
     * @param namespaces
     */
    private void storeNamespaces(String[] namespaces) {
        Namespaces.namespaces = namespaces;
    }

}
