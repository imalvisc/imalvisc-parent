package com.imalvisc.user.controller.demo;

import com.imalvisc.api.order.OrderService;
import com.imalvisc.api.order.dto.CreateOrderDTO;
import com.imalvisc.api.order.vo.CreateOrderVO;
import com.imalvisc.user.resp.RespMessage;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author imalvisc
 * @version v1.0
 * @ClassName FeignController
 * @Description Feign Demo
 * @motto 学会编程而不是学会编码！
 * @date 2019-06-04 18:11
 * @Copyright Guangzhou CheXingYi Information Technology Co., Ltd.
 */
@Api(value = "Feign演示", tags = "Feign演示")
@RestController
@RequestMapping(value = "/demo/feign")
public class FeignController {

    @Autowired
    private OrderService orderService;

    @ApiOperation(value = "调用订单服务", notes = "调用订单服务")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "type", value = "演示类型（1服务熔断 2服务降级 3正常）", dataType = "int", paramType = "query", required = true)
    })
    @HystrixCommand(fallbackMethod = "createOrderFallback", commandProperties = {
            //单位时间内统计次数
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            //单位时间内失败次数
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
            //休眠多少毫秒后回到半开状态
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000")
    })
    @GetMapping(value = "/createOrder")
    public RespMessage<CreateOrderVO> createOrder(Integer type) {
        System.out.println(Thread.currentThread().getName());
        System.out.println(type);
        return RespMessage.success(
                orderService.createOrder(CreateOrderDTO.builder().orderType(type).orderTitle("用户中心调用订单中心服务").build()
                ));
    }

    /**
     * 调用订单服务-服务降级回调方法
     *
     * @param type
     * @return
     */
    @SuppressWarnings(value = "unused")
    public RespMessage<CreateOrderVO> createOrderFallback(Integer type) {
        //服务回滚后, 这里应该使用分布式事务回滚下游服务的事务
        System.out.println(type);
        return RespMessage.fail("服务拥挤，稍候再试！");
    }

}
