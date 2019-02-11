package com.imalvisc.api.auth.service.impl;

import com.imalvisc.api.auth.service.AuthSerivce;
import com.imalvisc.api.auth.service.MemberSerivce;
import com.imalvisc.common.model.po.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthSerivce {

    @Autowired
    private MemberSerivce memberSerivce;

    @Override
    public Member login(String name, String password) {
        Member member = memberSerivce.findByName(name);
        return member;
    }

}
