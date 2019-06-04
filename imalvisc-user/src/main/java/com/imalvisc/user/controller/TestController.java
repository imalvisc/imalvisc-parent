package com.imalvisc.user.controller;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author imalvisc
 * @version v1.0
 * @ClassName TestController
 * @Description TODO
 * @motto 学会编程而不是学会编码！
 * @date 2019-06-04 18:11
 * @Copyright Guangzhou CheXingYi Information Technology Co., Ltd.
 */
@RestController
@RequestMapping(value = "/test")
public class TestController {

    @Autowired
    private TestProperties test;

    @ApolloConfig(value = "imalvisc")
    private Config config;

    @GetMapping(value = "/demo")
    public String demo() {
        return config.getProperty("test", null) + "-----" + test;
    }

}
