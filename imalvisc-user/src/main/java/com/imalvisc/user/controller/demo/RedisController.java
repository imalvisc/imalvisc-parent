package com.imalvisc.user.controller.demo;

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
    private StringRedisTemplate stringRedisTemplate;

    @ApiOperation(value = "测试", notes = "测试")
    @GetMapping(value = "/test")
    public String test() {
        stringRedisTemplate.opsForValue().set("test", "陈嘉明---Redis");
        return stringRedisTemplate.opsForValue().get("test");
    }

}
