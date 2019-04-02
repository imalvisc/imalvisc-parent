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
@ConfigurationProperties(prefix = "redis")
@PropertySource(value = "classpath:env.properties")
public class RedisProperties {

    private JedisPoolProperties pool = new JedisPoolProperties();
    private String host;
    private int port;
    private String password;
    private int timeout;
    private int database;

    @PostConstruct
    public void init() {
        log.info("Redis配置参数：{}", this.toString());
    }

}
