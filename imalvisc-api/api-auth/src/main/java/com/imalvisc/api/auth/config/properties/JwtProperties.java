package com.imalvisc.api.auth.config.properties;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@Data
@NoArgsConstructor
@Accessors(chain = true)
@Component
@ConfigurationProperties(prefix = "jwt")
public class JwtProperties {

    private String claim;
    private String prefix;
    private String secret;
    private String accessTokenExpired;
    private String refreshTokenExpired;

    @PostConstruct
    public void init() {
        log.info("Jwt配置参数：{}", this.toString());
    }

}
