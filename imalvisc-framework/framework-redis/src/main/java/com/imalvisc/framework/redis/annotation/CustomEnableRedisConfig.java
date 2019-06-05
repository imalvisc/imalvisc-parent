package com.imalvisc.framework.redis.annotation;

import com.imalvisc.framework.redis.config.CustomRedisAutoConfiguration;
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
 * @ClassName CustomRedisAutoConfiguration
 * @Description 开启Redis自动配置注解
 * @motto 学会编程而不是学会编码！
 * @date 2019-04-02 10:31
 * @Copyright Guangzhou CheXingYi Information Technology Co., Ltd.
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import(value = {CustomRedisAutoConfiguration.class})
public @interface CustomEnableRedisConfig {

}
