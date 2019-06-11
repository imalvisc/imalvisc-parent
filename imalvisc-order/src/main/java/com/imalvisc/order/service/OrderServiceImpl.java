package com.imalvisc.order.service;

import com.imalvisc.api.order.OrderService;
import com.imalvisc.api.order.dto.CreateOrderDTO;
import com.imalvisc.api.order.vo.CreateOrderVO;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author imalvisc
 * @version v1.0
 * @ClassName OrderServiceImpl
 * @Description 订单服务
 * @motto 学会编程而不是学会编码！
 * @date 2019-06-11 15:30
 * @Copyright Guangzhou CheXingYi Information Technology Co., Ltd.
 */
@RequestMapping(value = "/order")
@Service
public class OrderServiceImpl implements OrderService {

    @PostMapping(value = "/createOrder")
    @ResponseBody
    @Override
    public CreateOrderVO createOrder(@RequestBody CreateOrderDTO orderDTO) {
        System.out.println(orderDTO.getOrderTitle());
        if (orderDTO.getOrderType() == 1) {
            throw new RuntimeException("订单中心异常");
        } else if (orderDTO.getOrderType() == 2) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return CreateOrderVO.builder().orderTitle(orderDTO.getOrderTitle()).build();
    }

}
