package com.imalvisc.api.auth.service;

import com.imalvisc.common.model.po.Member;

import java.util.List;

public interface AuthSerivce {

    Member login(String name, String password);

}
