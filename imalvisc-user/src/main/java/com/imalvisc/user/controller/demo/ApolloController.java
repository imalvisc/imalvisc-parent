package com.imalvisc.user.controller.demo;

import com.imalvisc.framework.apollo.utils.ApolloUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author imalvisc
 * @version v1.0
 * @ClassName ApolloController
 * @Description Apollo Demo
 * @motto 学会编程而不是学会编码！
 * @date 2019-06-04 18:11
 * @Copyright Guangzhou CheXingYi Information Technology Co., Ltd.
 */
@Api(value = "Apollo演示", tags = "Apollo演示")
@RestController
@RequestMapping(value = "/demo/apollo")
public class ApolloController {

    @Autowired
    private TestProperties test;

    @ApiOperation(value = "测试", notes = "测试")
    @GetMapping(value = "/test")
    public String test() {
        return ApolloUtils.getProperty("imalvisc", "test", "") + "-----" + test;
        //return null;
    }

}
