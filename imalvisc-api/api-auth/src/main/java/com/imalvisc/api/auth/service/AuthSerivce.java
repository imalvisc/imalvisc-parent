package com.imalvisc.api.auth.service;

import com.imalvisc.api.auth.model.vo.AuthTokenVO;
import com.imalvisc.common.model.po.Member;

import java.util.List;

public interface AuthSerivce {

    AuthTokenVO login(String name, String password);

}