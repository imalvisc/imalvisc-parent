package com.imalvisc.api.order.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author imalvisc
 * @version v1.0
 * @ClassName CreateOrderVO
 * @Description 创建订单DTO
 * @motto 学会编程而不是学会编码！
 * @date 2019-06-11 15:09
 * @Copyright Guangzhou CheXingYi Information Technology Co., Ltd.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateOrderVO {

    private Integer orderType;

    private String orderTitle;

}
