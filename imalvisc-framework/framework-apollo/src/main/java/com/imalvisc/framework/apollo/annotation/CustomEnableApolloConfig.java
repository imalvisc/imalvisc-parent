package com.imalvisc.framework.apollo.annotation;

import com.imalvisc.framework.apollo.registrar.CustomApolloConfigRegistrar;
import org.springframework.context.annotation.Import;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author imalvisc
 * @version v1.0
 * @ClassName CustomEnableApolloConfig
 * @Description 开启Apollo配置注解
 * @motto 学会编程而不是学会编码！
 * @date 2019-06-04 20:49
 * @Copyright Guangzhou CheXingYi Information Technology Co., Ltd.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Inherited
@Import(value = {CustomApolloConfigRegistrar.class})
public @interface CustomEnableApolloConfig {

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
