package com.imalvisc.api.common.swagger.annotation;

import com.imalvisc.api.common.swagger.config.SwaggerAutoConfiguration;
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
 * @ClassName EnableSwagger
 * @Description 开启Swagger自动配置注解
 * @motto 学会编程而不是学会编码！
 * @date 2019-04-02 10:31
 * @Copyright Guangzhou CheXingYi Information Technology Co., Ltd.
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({SwaggerAutoConfiguration.class})
public @interface EnableSwagger {

}
