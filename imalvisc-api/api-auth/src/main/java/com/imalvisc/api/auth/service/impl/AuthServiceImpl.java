package com.imalvisc.api.auth.service.impl;

import com.imalvisc.api.auth.model.state.AuthTokenType;
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
        AuthTokenVO result = new AuthTokenVO()
                .setAccessToken(JwtUtils.create(member.getId(), AuthTokenType.ACCESS_TOKEN))
                .setRefreshToken(JwtUtils.create(member.getId(), AuthTokenType.REFRESH_TOKEN));
        return result;
    }

}
