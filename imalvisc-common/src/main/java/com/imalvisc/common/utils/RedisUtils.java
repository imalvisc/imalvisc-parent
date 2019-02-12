package com.imalvisc.common.utils;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.io.Serializable;

public class RedisUtils {

    private static StringRedisTemplate stringRedisTemplate;
    private static final String STRING_REDIS_TEMPLATE_BEAN_NAME = "stringRedisTemplate";
    private static RedisTemplate<String, Object> redisTemplate;
    private static final String REDIS_TEMPLATE_BEAN_NAME = "redisTemplate";

    static {
        stringRedisTemplate = (StringRedisTemplate) SpringUtils.getBean(STRING_REDIS_TEMPLATE_BEAN_NAME);
        redisTemplate = (RedisTemplate<String, Object>) SpringUtils.getBean(REDIS_TEMPLATE_BEAN_NAME);
    }

    public static void setString(String key, String value) {
        stringRedisTemplate.opsForValue().set(key, value);
    }

    public static String getString(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }

    public static void setObject(String key, Serializable object) {
        redisTemplate.opsForValue().set(key, object);
    }

    public static Object getObject(String key) {
        return redisTemplate.opsForValue().get(key);
    }

}
