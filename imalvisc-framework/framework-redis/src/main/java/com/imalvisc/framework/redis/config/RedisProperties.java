package com.imalvisc.framework.redis.config;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author imalvisc
 * @version v1.0
 * @ClassName RedisProperties
 * @Description Redis配置信息
 * @motto 学会编程而不是学会编码！
 * @date 2019-04-02 10:36
 * @Copyright Guangzhou CheXingYi Information Technology Co., Ltd.
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ConfigurationProperties(prefix = "redis")
public class RedisProperties {

    /**
     * 连接池信息
     */
    private JedisPoolProperties pool = new JedisPoolProperties();

    /**
     * 主机
     */
    private String host;

    /**
     * 端口
     */
    private int port;

    /**
     * 密码
     */
    private String password;

    /**
     * 超时时间(单位:s)
     */
    private int timeout;

    /**
     * 数据库
     */
    private int database;

    @PostConstruct
    public void init() {
        log.info("Redis初始化配置参数：{}", this.toString());
    }

}
