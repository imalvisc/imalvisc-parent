package com.imalvisc.api.order;

import com.imalvisc.api.order.dto.CreateOrderDTO;
import com.imalvisc.api.order.vo.CreateOrderVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author imalvisc
 * @version v1.0
 * @ClassName OrderService
 * @Description 订单服务
 * @motto 学会编程而不是学会编码！
 * @date 2019-06-11 15:08
 * @Copyright Guangzhou CheXingYi Information Technology Co., Ltd.
 */
@FeignClient(value = "order")
@RequestMapping(value = "/order")
public interface OrderService {

    @PostMapping(value = "/createOrder")
    CreateOrderVO createOrder(@RequestBody CreateOrderDTO orderDTO);

}
