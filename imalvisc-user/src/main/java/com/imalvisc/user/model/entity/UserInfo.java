package com.imalvisc.user.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * @author imalvisc
 * @version v1.0
 * @ClassName UserInfo
 * @Description 用户信息实体类
 * @motto 学会编程而不是学会编码！
 * @date 2019-04-29 11:08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@TableName
public class UserInfo extends Model<UserInfo> {

    /**
     * ID
     */
    @TableId
    private Long id;

    /**
     * 用户名
     */
    @NotBlank(message = "用户名不能为空")
    private String userName;

    /**
     * 密文密码
     */
    private String password;

    /**
     * 删除标识
     */
    @TableLogic
    private Integer delFlag;

}
