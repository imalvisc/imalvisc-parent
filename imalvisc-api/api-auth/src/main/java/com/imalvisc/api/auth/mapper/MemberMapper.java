package com.imalvisc.api.auth.mapper;

import com.imalvisc.common.model.po.Member;

import java.util.List;

public interface MemberMapper {

    List<Member> findAll();

    Member findByName(String name);

}
