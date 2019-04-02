package com.imalvisc.api.common.swagger.config;

import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
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
 * @ClassName SwaggerAutoConfiguration
 * @Description Swagger自动配置类
 * @motto 学会编程而不是学会编码！
 * @date 2019-04-02 10:31
 * @Copyright Guangzhou CheXingYi Information Technology Co., Ltd.
 */
@Configuration
@EnableSwagger2
@EnableSwaggerBootstrapUI
public class SwaggerAutoConfiguration {

    /**
     * 开启Swagger
     * @return
     */
    @Bean
    public Docket createDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
            .enable(true)
            .apiInfo(apiInfo())
            .groupName("imalvisc-用户服务接口文档")
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.imalvisc.api.user.controller"))
            .paths(PathSelectors.any())
            .build();
    }

    /**
     * 构建API信息对象
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            .title("imalvisc-用户服务接口文档")
            .description("imalvisc-用户服务接口文档")
            .termsOfServiceUrl("http://localhost:6001/")
            .contact(new Contact("imalvisc", "https://www.baidu.com/", "13570038865@163.com"))
            .version("1.0")
            .build();
    }

}
