package com.imalvisc.api.auth.controller;

import com.imalvisc.api.auth.service.MemberSerivce;
import com.imalvisc.common.model.po.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/member")
public class MemberController {

    @Autowired
    private MemberSerivce memberSerivce;

    @GetMapping(value = "/findAll")
    public List<Member> findAll() {
        return memberSerivce.findAll();
    }

}
