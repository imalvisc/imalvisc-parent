package com.imalvisc.user.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * @author imalvisc
 * @version v1.0
 * @ClassName UserInfo
 * @Description 用户信息DTO
 * @motto 学会编程而不是学会编码！
 * @date 2019-04-29 11:08
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserInfoDTO {

    /**
     * 用户名
     */
    @NotBlank(message = "用户名不能为空")
    private String userName;

    /**
     * 密文密码
     */
    @NotBlank(message = "密码不能为空")
    private String password;

}
