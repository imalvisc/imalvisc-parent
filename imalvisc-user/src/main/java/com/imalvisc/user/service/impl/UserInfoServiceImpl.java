package com.imalvisc.user.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.imalvisc.user.mapper.UserInfoMapper;
import com.imalvisc.user.model.dto.PageDTO;
import com.imalvisc.user.model.entity.UserInfo;
import com.imalvisc.user.model.vo.PageVO;
import com.imalvisc.user.service.UserInfoService;
import com.imalvisc.user.util.PageUtils;
import org.springframework.stereotype.Service;

/**
 * @author imalvisc
 * @version v1.0
 * @ClassName UserInfoServiceImpl
 * @Description 用户信息服务实现类
 * @motto 学会编程而不是学会编码！
 * @date 2019-04-29 11:16
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo>
        implements UserInfoService {

    public PageVO<UserInfo> selectPage(PageDTO pageDTO) {
        IPage<UserInfo> iPage = PageUtils.toPage(pageDTO, UserInfo.class);
        iPage = this.page(iPage);
        return PageUtils.parsePage(iPage);
    }

    public boolean insert(UserInfo userInfo) {
        return this.save(userInfo);
    }

}
