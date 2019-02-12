package com.imalvisc.api.auth.service.impl;

import com.imalvisc.api.auth.model.state.TokenType;
import com.imalvisc.api.auth.model.vo.AuthTokenVO;
import com.imalvisc.api.auth.service.AuthSerivce;
import com.imalvisc.api.auth.service.MemberSerivce;
import com.imalvisc.api.auth.utils.JwtUtils;
import com.imalvisc.common.model.po.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthSerivce {

    @Autowired
    private MemberSerivce memberSerivce;

    @Override
    public AuthTokenVO login(String name, String password) {
        Member member = memberSerivce.findByName(name);
        return new AuthTokenVO().setAccessToken(JwtUtils.create(member.getId(), TokenType.ACCESS_TOKEN));
    }

}
