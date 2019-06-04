package com.imalvisc.apollo.registrar;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.ConfigService;
import com.ctrip.framework.apollo.model.ConfigChange;
import com.ctrip.framework.apollo.spring.annotation.ApolloAnnotationProcessor;
import com.ctrip.framework.apollo.spring.annotation.ApolloJsonValueProcessor;
import com.ctrip.framework.apollo.spring.annotation.SpringValueProcessor;
import com.ctrip.framework.apollo.spring.config.PropertySourcesProcessor;
import com.ctrip.framework.apollo.spring.property.SpringValueDefinitionProcessor;
import com.ctrip.framework.apollo.spring.util.BeanRegistrationUtil;
import com.google.common.collect.Lists;
import com.imalvisc.apollo.annotation.CustomEnableApolloConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.cloud.context.scope.refresh.RefreshScope;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
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
@Slf4j
@Component
public class CustomApolloConfigRegistrar implements ImportBeanDefinitionRegistrar {

    /**
     * SpringCloud提供的刷新SpringBoot环境配置的核心类
     */
    @Autowired
    private RefreshScope refreshScope;

    /**
     * Apollo命名空间
     */
    private static String[] namespaces;

    /**
     * 执行监听
     *
     * @return
     */
    @PostConstruct
    public void doListen() {
        if (namespaces != null && namespaces.length > 0) {
            Config config;
            for (String namespace : namespaces) {
                config = ConfigService.getConfig(namespace);
                if (config != null) {
                    config.addChangeListener(changeEvent -> {
                        for (String key : changeEvent.changedKeys()) {
                            ConfigChange change = changeEvent.getChange(key);
                            log.info("Apollo Found change - namespace: {}, key: {}, oldValue: {}, newValue: {}, changeType: {}",
                                    changeEvent.getNamespace(), change.getPropertyName(), change.getOldValue(), change.getNewValue(), change.getChangeType());
                        }
                        //利用SpringCloud提供的RefreshScope来刷新SpringBoot的环境配置
                        refreshScope.refreshAll();
                    });
                }
            }
        }
    }

    /**
     * 注册Apollo核心Bean以及配置刷新监听器, 模仿Apollo原生代码
     *
     * @param importingClassMetadata
     * @param registry
     */
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        AnnotationAttributes attributes = AnnotationAttributes.fromMap(importingClassMetadata.getAnnotationAttributes(CustomEnableApolloConfig.class.getName()));
        assert attributes != null;
        String[] namespaces = attributes.getStringArray("value");
        CustomApolloConfigRegistrar.namespaces = namespaces;
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
        //注册自身到SpringIOC容器中, 是Apollo配置刷新监听器生效
        registry.registerBeanDefinition(CustomApolloConfigRegistrar.class.getName(), BeanDefinitionBuilder.rootBeanDefinition(CustomApolloConfigRegistrar.class).getBeanDefinition());
    }

}
