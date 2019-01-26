package com.imalvisc.api.auth.controller;

import com.imalvisc.api.auth.service.MemberSerivce;
import com.imalvisc.common.model.po.Member;
import com.imalvisc.common.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/member")
public class MemberController {

    @Autowired
    private MemberSerivce memberSerivce;

    @GetMapping(value = "/findAll")
    public List<Member> findAll() {
        RedisUtil.setString("key", "测试字符串");
        log.info("key的值为：{}", RedisUtil.getString("key"));
        RedisUtil.setObject("member", memberSerivce.findAll().get(0));
        log.info("key的值为：{}", RedisUtil.getObject("member"));
        return memberSerivce.findAll();
    }

}
