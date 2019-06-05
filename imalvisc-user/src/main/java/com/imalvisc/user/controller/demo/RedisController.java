package com.imalvisc.user.controller.demo;

import com.imalvisc.framework.redis.support.RedisDistributionLockSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author imalvisc
 * @version v1.0
 * @ClassName RedisController
 * @Description Redis Demo
 * @motto 学会编程而不是学会编码！
 * @date 2019-06-04 18:11
 * @Copyright Guangzhou CheXingYi Information Technology Co., Ltd.
 */
@Api(value = "Redis演示", tags = "Redis演示")
@RestController
@RequestMapping(value = "/demo/redis")
public class RedisController {

    @Autowired
    private RedisDistributionLockSupport redisDistributionLockSupport;
    private static final long EXPIRED_TIME = 10 * 1000;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @ApiOperation(value = "测试", notes = "测试")
    @GetMapping(value = "/test")
    public String test() {
        stringRedisTemplate.opsForValue().set("test", "陈嘉明---Redis");
        return stringRedisTemplate.opsForValue().get("test");
    }

    @ApiOperation(value = "模拟秒杀", notes = "模拟秒杀(请求后5s内用其他工具请求该接口, 查看效果)")
    @GetMapping(value = "/seckill")
    public String seckill() {
        String value = String.valueOf(System.currentTimeMillis() + EXPIRED_TIME);
        if (!redisDistributionLockSupport.lock("1", value)) {
            return "排队人数太多, 请稍后再试";
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        redisDistributionLockSupport.release("1", value);
        return "恭喜您, 秒杀成功";
    }

}
