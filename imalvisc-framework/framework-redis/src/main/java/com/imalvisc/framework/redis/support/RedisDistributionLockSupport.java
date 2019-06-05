package com.imalvisc.framework.redis.support;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author imalvisc
 * @version v1.0
 * @ClassName RedisDistributionLockSupport
 * @Description Redis分布式锁
 * @motto 学会编程而不是学会编码！
 * @date 2019-06-05 16:41
 * @Copyright Guangzhou CheXingYi Information Technology Co., Ltd.
 */
@Slf4j
public class RedisDistributionLockSupport {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 设置分布式锁
     *
     * @param key   -唯一标识
     * @param value -过期时间(时间戳ms)
     * @return
     */
    public boolean lock(String key, String value) {
        //采用NX(当锁定资源不存在的时候才能Set成功)方式设置锁
        Boolean lockResult = stringRedisTemplate.opsForValue().setIfAbsent(key, value);
        if (lockResult != null && lockResult) {
            return true;
        }
        //若Set失败, 则判断锁是否超时
        //判断锁是否超时, 超时则重新设置, 防止异常操作不释放锁时导致死锁的问题
        String currentValue = stringRedisTemplate.opsForValue().get(key);
        //若未超时, 则抢锁失败
        if (StringUtils.isEmpty(currentValue) || Long.parseLong(currentValue) > System.currentTimeMillis()) {
            return false;
        }
        //获取上一个锁的value, 并设置新的value
        String oldValue = stringRedisTemplate.opsForValue().getAndSet(key, value);
        //使用getAndSet的目的是为了最终需要判断在设置新value前的value和用来判断超时的value是否相等, 是才返回成功, 避免在判断超时和设置新value之间存在并发操作
        return !StringUtils.isEmpty(oldValue) && oldValue.equals(currentValue);
    }

    /**
     * 释放分布式锁
     *
     * @param key
     * @param value
     */
    public void release(String key, String value) {
        //使用lua脚本, 保证操作的原子性
        String luaScript = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
        DefaultRedisScript<Long> redisScript = new DefaultRedisScript<>();
        redisScript.setResultType(Long.class);
        redisScript.setScriptText(luaScript);
        Long result = stringRedisTemplate.execute(redisScript, Collections.singletonList(key), value);
        log.info("释放Redis分布式锁, key: {}, value: {}, result: {}", key, value, result);
    }

}
