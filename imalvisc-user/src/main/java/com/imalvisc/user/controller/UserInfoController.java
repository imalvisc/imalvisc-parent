package com.imalvisc.user.controller;

import com.imalvisc.user.model.dto.PageDTO;
import com.imalvisc.user.model.entity.UserInfo;
import com.imalvisc.user.model.vo.PageVO;
import com.imalvisc.user.resp.RespMessage;
import com.imalvisc.user.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @GetMapping(value = "/list")
    public RespMessage<PageVO<UserInfo>> list(PageDTO pageDTO) {
        return RespMessage.success(userInfoService.selectPage(pageDTO));
    }

    @PostMapping(value = "/save")
    public RespMessage<Boolean> save(@RequestBody @Validated UserInfo userInfo, BindingResult bindingResult) {
        return RespMessage.success(userInfoService.insert(userInfo));
    }

    @GetMapping(value = "/delete")
    public RespMessage<Boolean> delete(Long id) {
        return RespMessage.success(userInfoService.removeById(id));
    }

}
