package com.imalvisc.framework.swagger.annotation;

import com.imalvisc.framework.swagger.config.CustomSwaggerAutoConfiguration;
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
 * @ClassName CustomEnableSwaggerConfig
 * @Description 开启Swagger自动配置注解
 * @motto 学会编程而不是学会编码！
 * @date 2019-04-02 10:31
 * @Copyright Guangzhou CheXingYi Information Technology Co., Ltd.
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({CustomSwaggerAutoConfiguration.class})
public @interface CustomEnableSwaggerConfig {

}
