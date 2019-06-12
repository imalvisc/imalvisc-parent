package com.imalvisc.user.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
@Table(name = "tb_user_info")
public class UserInfo {

    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密文密码
     */
    private String password;

    /**
     * 删除标识
     */
    private Integer delFlag;

}
