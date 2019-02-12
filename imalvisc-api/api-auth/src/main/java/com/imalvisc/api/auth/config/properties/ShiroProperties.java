package com.imalvisc.api.auth.config.properties;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Map;

@Slf4j
@Data
@NoArgsConstructor
@Accessors(chain = true)
@Component
@ConfigurationProperties(prefix = "shiro")
public class ShiroProperties {

    private Map<String, String> filterChain;

    @PostConstruct
    public void init() {
        log.info("Shiro配置参数：{}", this.toString());
    }

}
