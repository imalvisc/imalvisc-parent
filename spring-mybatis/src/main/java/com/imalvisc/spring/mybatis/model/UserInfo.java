package com.imalvisc.spring.mybatis.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author imalvisc
 * @version v1.0
 * @ClassName UserInfo
 * @Description 用户信息实体类
 * @motto 学会编程而不是学会编码！
 * @date 2019-04-29 11:08
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserInfo {

    /**
     * ID
     */
    private Long id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密文密码
     */
    private String password;

}
