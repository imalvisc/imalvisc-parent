package com.imalvisc.api.user.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author imalvisc
 * @version v1.0
 * @ClassName UserInfo
 * @Description 用户信息实体类
 * @motto 学会编程而不是学会编码！
 * @date 2019-03-29 15:21
 * @Copyright Guangzhou CheXingYi Information Technology Co., Ltd.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
@TableName(value = "tb_user_info")
public class UserInfo {

    @TableId(type = IdType.INPUT)
    private String id;

    private String userName;

    private String password;

}
