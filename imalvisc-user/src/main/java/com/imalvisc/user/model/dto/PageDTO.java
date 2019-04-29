package com.imalvisc.user.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author imalvisc
 * @version v1.0
 * @ClassName PageDTO
 * @Description 分页DTO
 * @motto 学会编程而不是学会编码！
 * @date 2019-04-29 14:06
 * @Copyright Guangzhou CheXingYi Information Technology Co., Ltd.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PageDTO {

    /**
     * 当前页数
     */
    private Integer current = 1;

    /**
     * 显示条数
     */
    private Integer size = 20;

}
