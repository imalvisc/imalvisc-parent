package com.imalvisc.user.controller;

import com.imalvisc.user.model.entity.UserInfo;
import com.imalvisc.user.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author imalvisc
 * @version v1.0
 * @ClassName UserInfoController
 * @Description 用户信息控制器
 * @motto 学会编程而不是学会编码！
 * @date 2019-04-29 11:07
 */
@RestController
@RequestMapping(value = "/userInfo")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @GetMapping(value = "/save")
    public boolean save(String userName, String password) {
        return userInfoService.insert(UserInfo.builder().userName(userName).password(password).build());
    }

    @GetMapping(value = "/delete")
    public Boolean delete(Long id) {
        //return userInfoService.removeById(id);
        return UserInfo.builder().id(id).build().deleteById();
    }

}
