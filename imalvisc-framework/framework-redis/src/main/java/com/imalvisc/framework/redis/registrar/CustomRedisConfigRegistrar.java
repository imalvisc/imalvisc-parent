package com.imalvisc.framework.redis.registrar;

import com.imalvisc.framework.redis.support.RedisDistributionLockSupport;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author imalvisc
 * @version v1.0
 * @ClassName CustomRedisConfigRegistrar
 * @Description 自定义Redis配置注册器
 * @motto 学会编程而不是学会编码！
 * @date 2019-06-05 16:44
 * @Copyright Guangzhou CheXingYi Information Technology Co., Ltd.
 */
public class CustomRedisConfigRegistrar implements ImportBeanDefinitionRegistrar {

    /**
     * 注册基于Redis环境的Bean
     *
     * @param importingClassMetadata
     * @param registry
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

        //分布式锁
        registry.registerBeanDefinition(RedisDistributionLockSupport.class.getName(),
                BeanDefinitionBuilder.rootBeanDefinition(RedisDistributionLockSupport.class).getBeanDefinition());

    }

}
