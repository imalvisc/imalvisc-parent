package com.imalvisc.framework.swagger.config;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.annotation.PostConstruct;

/**
 * @author imalvisc
 * @version v1.0
 * @ClassName SwaggerProperties
 * @Description Swagger配置信息
 * @motto 学会编程而不是学会编码！
 * @date 2019-04-02 10:36
 * @Copyright Guangzhou CheXingYi Information Technology Co., Ltd.
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ConfigurationProperties(prefix = "swagger")
public class SwaggerProperties {

    @PostConstruct
    public void init() {
        log.info("Swagger初始化配置信息: {}", this);
    }

    /**
     * 是否开启
     */
    private Boolean enable;

    /**
     * 扫描包
     */
    private String basePackage;

    /**
     * 标题
     */
    private String title;

    /**
     * 描述
     */
    private String description;

    /**
     * 服务URL
     */
    private String termsOfServiceUrl;

    /**
     * 版本
     */
    private String version;

    /**
     * 联系人信息
     */
    private Contact contact;

    /**
     * 联系人信息
     */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Contact {

        /**
         * 姓名
         */
        private String name;

        /**
         * 个人主页
         */
        private String url;

        /**
         * 邮箱
         */
        private String email;
    }

}
