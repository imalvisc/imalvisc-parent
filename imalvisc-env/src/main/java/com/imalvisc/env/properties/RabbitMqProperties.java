package com.imalvisc.env.properties;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@Data
@NoArgsConstructor
@Accessors(chain = true)
@Component
@ConfigurationProperties(prefix = "rabbitmq")
@PropertySource(value = "classpath:env.properties")
public class RabbitMqProperties {

    private String host;
    private int port;
    private String username;
    private String password;

    @PostConstruct
    public void init() {
        log.info("RabbitMq配置参数：{}", this.toString());
    }

}
