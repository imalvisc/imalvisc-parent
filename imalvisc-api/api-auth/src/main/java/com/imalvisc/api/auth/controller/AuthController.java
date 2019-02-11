package com.imalvisc.api.auth.controller;

import com.imalvisc.api.auth.service.AuthSerivce;
import com.imalvisc.common.model.po.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
