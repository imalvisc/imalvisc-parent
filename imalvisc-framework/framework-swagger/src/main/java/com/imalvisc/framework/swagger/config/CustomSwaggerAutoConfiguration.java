package com.imalvisc.framework.swagger.config;

import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author imalvisc
 * @version v1.0
 * @ClassName CustomSwaggerAutoConfiguration
 * @Description 自定义Swagger自动配置类
 * @motto 学会编程而不是学会编码！
 * @date 2019-04-02 10:31
 * @Copyright Guangzhou CheXingYi Information Technology Co., Ltd.
 */
@Configuration
@EnableConfigurationProperties(value = SwaggerProperties.class)
@EnableSwagger2
@EnableSwaggerBootstrapUI
public class CustomSwaggerAutoConfiguration {

    @Autowired
    private SwaggerProperties swaggerProperties;

    /**
     * 开启Swagger
     *
     * @return
     */
    @Bean
    public Docket createDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(swaggerProperties.getEnable())
                .apiInfo(apiInfo())
                .groupName(swaggerProperties.getTitle())
                .select()
                .apis(RequestHandlerSelectors.basePackage(swaggerProperties.getBasePackage()))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 构建API信息对象
     *
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(swaggerProperties.getTitle())
                .description(swaggerProperties.getDescription())
                .termsOfServiceUrl(swaggerProperties.getTermsOfServiceUrl())
                .contact(new Contact(swaggerProperties.getContact().getName(), swaggerProperties.getContact().getUrl(), swaggerProperties.getContact().getEmail()))
                .version(swaggerProperties.getVersion())
                .build();
    }

}
