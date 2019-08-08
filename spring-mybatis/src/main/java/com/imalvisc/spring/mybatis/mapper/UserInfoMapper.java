package com.imalvisc.spring.mybatis.mapper;

import com.imalvisc.spring.mybatis.model.UserInfo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserInfoMapper {

    @Select(value = {
            "select * from tb_user_info"
    })
    List<UserInfo> selectAll();

}
