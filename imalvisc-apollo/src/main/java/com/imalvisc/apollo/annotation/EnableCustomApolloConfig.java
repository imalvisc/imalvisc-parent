package com.imalvisc.apollo.annotation;

import com.imalvisc.apollo.config.ApolloRefreshAutoConfiguration;
import com.imalvisc.apollo.registrar.CustomApolloConfigRegistrar;
import org.springframework.context.annotation.Import;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author imalvisc
 * @version v1.0
 * @ClassName EnableCustomApolloConfig
 * @Description 开启Apollo配置注解
 * @motto 学会编程而不是学会编码！
 * @date 2019-06-04 20:49
 * @Copyright Guangzhou CheXingYi Information Technology Co., Ltd.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(value = {CustomApolloConfigRegistrar.class, ApolloRefreshAutoConfiguration.class})
public @interface EnableCustomApolloConfig {

    /**
     * namespace命名空间, 默认为Apollo默认的application
     *
     * @return
     */
    String[] value() default "application";

    /**
     * 加载顺序
     *
     * @return
     */
    int order() default 2147483647;

}
