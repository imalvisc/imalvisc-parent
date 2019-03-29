package com.imalvisc.api.user.controller;

import com.imalvisc.api.user.model.entity.UserInfo;
import com.imalvisc.api.user.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author imalvisc
 * @version v1.0
 * @ClassName UserInfoController
 * @Description 用户信息Controller
 * @motto 学会编程而不是学会编码！
 * @date 2019-03-29 15:32
 * @Copyright Guangzhou CheXingYi Information Technology Co., Ltd.
 */
@RestController
@RequestMapping(value = "/userInfo")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @GetMapping(value = "/getById")
    public UserInfo getById(@RequestParam String id) {
        return userInfoService.getById(id);
    }

}
