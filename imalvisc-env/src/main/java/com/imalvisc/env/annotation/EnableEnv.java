package com.imalvisc.env.annotation;

import com.imalvisc.env.config.DataSourceAutoConfiguration;
import com.imalvisc.env.config.RabbitMqAutoConfiguration;
import com.imalvisc.env.config.RedisAutoConfiguration;
import com.imalvisc.env.properties.DataSourceProperties;
import com.imalvisc.env.properties.RabbitMqProperties;
import com.imalvisc.env.properties.RedisProperties;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.context.annotation.Import;

/**
 * @author imalvisc
 * @version v1.0
 * @ClassName EnableEnv
 * @Description 开启架构环境（数据源、Redis、RabbitMQ等）自动配置注解
 * @motto 学会编程而不是学会编码！
 * @date 2019-04-02 10:31
 * @Copyright Guangzhou CheXingYi Information Technology Co., Ltd.
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({DataSourceProperties.class, DataSourceAutoConfiguration.class, RedisProperties.class,
    RedisAutoConfiguration.class, RabbitMqProperties.class, RabbitMqAutoConfiguration.class})
public @interface EnableEnv {

}
