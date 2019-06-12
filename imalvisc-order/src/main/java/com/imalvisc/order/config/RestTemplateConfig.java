package com.imalvisc.order.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author imalvisc
 * @version v1.0
 * @ClassName RestTemplateConfig
 * @Description TODO
 * @motto 学会编程而不是学会编码！
 * @date 2019-06-12 10:52
 * @Copyright Guangzhou CheXingYi Information Technology Co., Ltd.
 */
@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
