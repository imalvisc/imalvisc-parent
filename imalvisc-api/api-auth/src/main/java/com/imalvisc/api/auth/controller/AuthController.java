package com.imalvisc.api.auth.controller;

import com.imalvisc.api.auth.service.AuthSerivce;
import com.imalvisc.api.auth.service.MemberSerivce;
import com.imalvisc.common.model.po.Member;
import com.imalvisc.common.util.RabbitMqUtil;
import com.imalvisc.common.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping(value = "/auth")
public class AuthController {

    @Autowired
    private AuthSerivce authSerivce;

    @GetMapping(value = "/login")
    public Member login(String name, String password) {
        return authSerivce.login(name, password);
    }

}
