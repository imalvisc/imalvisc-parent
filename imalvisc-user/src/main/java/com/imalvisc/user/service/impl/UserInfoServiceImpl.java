package com.imalvisc.user.service.impl;

import com.imalvisc.user.mapper.UserInfoMapper;
import com.imalvisc.user.model.dto.PageDTO;
import com.imalvisc.user.model.dto.UserInfoDTO;
import com.imalvisc.user.model.entity.UserInfo;
import com.imalvisc.user.model.vo.PageVO;
import com.imalvisc.user.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author imalvisc
 * @version v1.0
 * @ClassName UserInfoServiceImpl
 * @Description 用户信息服务实现类
 * @motto 学会编程而不是学会编码！
 * @date 2019-04-29 11:16
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public PageVO<UserInfo> selectPage(PageDTO pageDTO) {
        return null;
    }

    @Override
    public List<UserInfo> selectList() {
        return userInfoMapper.selectAll();
    }

    @Override
    public boolean insert(UserInfoDTO userInfoDTO) {
        return false;
    }
}
