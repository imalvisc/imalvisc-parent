package com.imalvisc.framework.redis.config;

import com.imalvisc.framework.redis.core.CustomRedisSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

import java.time.Duration;

/**
 * @author imalvisc
 * @version v1.0
 * @ClassName CustomRedisAutoConfiguration
 * @Description 自定义Redis自动配置
 * @motto 学会编程而不是学会编码！
 * @date 2019-04-02 10:36
 * @Copyright Guangzhou CheXingYi Information Technology Co., Ltd.
 */
@Configuration
@EnableConfigurationProperties(value = RedisProperties.class)
public class CustomRedisAutoConfiguration {

    @Autowired
    private RedisProperties properties;

    /**
     * Redis连接工厂
     *
     * @return
     */
    @Bean
    @ConditionalOnMissingBean
    public RedisConnectionFactory redisConnectionFactory() {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(properties.getPool().getMaxActive());
        poolConfig.setMaxWaitMillis(properties.getPool().getMaxWait());
        poolConfig.setMaxIdle(properties.getPool().getMaxIdle());
        poolConfig.setMinIdle(properties.getPool().getMinIdle());
        poolConfig.setTestOnBorrow(properties.getPool().isTestOnBorrow());
        poolConfig.setTestOnReturn(properties.getPool().isTestOnReturn());
        poolConfig.setTestWhileIdle(properties.getPool().isTestWhileIdle());

        JedisClientConfiguration clientConfiguration = JedisClientConfiguration.builder()
                .usePooling().poolConfig(poolConfig)
                .and().connectTimeout(Duration.ofMillis(properties.getTimeout())).build();

        RedisStandaloneConfiguration redisConfig = new RedisStandaloneConfiguration();
        redisConfig.setHostName(properties.getHost());
        redisConfig.setPassword(RedisPassword.of(properties.getPassword()));
        redisConfig.setPort(properties.getPort());
        redisConfig.setDatabase(properties.getDatabase());

        return new JedisConnectionFactory(redisConfig, clientConfiguration);
    }

    /**
     * String操作模版
     *
     * @param redisConnectionFactory
     * @return
     */
    @Bean
    @ConditionalOnMissingBean
    public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
        stringRedisTemplate.setConnectionFactory(redisConnectionFactory);
        return stringRedisTemplate;
    }

    /**
     * Object操作模板
     *
     * @param redisConnectionFactory
     * @return
     */
    @Bean
    @ConditionalOnMissingBean
    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new CustomRedisSerializer());
        return redisTemplate;
    }

}
