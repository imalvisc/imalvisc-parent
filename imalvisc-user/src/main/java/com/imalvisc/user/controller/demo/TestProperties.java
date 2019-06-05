package com.imalvisc.user.controller.demo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * @author imalvisc
 * @version v1.0
 * @ClassName TestProperties
 * @Description TODO
 * @motto 学会编程而不是学会编码！
 * @date 2019-06-04 18:40
 * @Copyright Guangzhou CheXingYi Information Technology Co., Ltd.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Component
@ConfigurationProperties(prefix = "test")
@RefreshScope
public class TestProperties {

    private String a;

    private String b;

}
