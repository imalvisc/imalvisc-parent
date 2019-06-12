package com.imalvisc.user.controller;

import com.imalvisc.user.model.dto.PageDTO;
import com.imalvisc.user.model.dto.UserInfoDTO;
import com.imalvisc.user.model.entity.UserInfo;
import com.imalvisc.user.model.vo.PageVO;
import com.imalvisc.user.resp.RespMessage;
import com.imalvisc.user.service.UserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author imalvisc
 * @version v1.0
 * @ClassName UserInfoController
 * @Description 用户信息控制器
 * @motto 学会编程而不是学会编码！
 * @date 2019-04-29 11:07
 */
@Api(value = "用户管理", tags = "用户管理")
@RestController
@RequestMapping(value = "/userInfo")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @GetMapping(value = "/list")
    public RespMessage<PageVO<UserInfo>> list(PageDTO pageDTO) {
        return null;
    }

    @ApiOperation(value = "查询所有", notes = "查询所有")
    @GetMapping(value = "/select")
    public RespMessage<List<UserInfo>> select() {
        return RespMessage.success(userInfoService.selectList());
    }

    @PostMapping(value = "/save")
    public RespMessage<Boolean> save(@RequestBody @Validated UserInfoDTO userInfoDTO, BindingResult bindingResult) {
        return null;
    }

    @GetMapping(value = "/delete")
    public RespMessage<Boolean> delete(Long id) {
        return null;
    }

}
