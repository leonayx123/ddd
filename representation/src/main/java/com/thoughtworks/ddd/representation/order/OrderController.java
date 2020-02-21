package com.thoughtworks.ddd.representation.order;

import com.thoughtworks.ddd.api.common.CommonResponse;
import com.thoughtworks.ddd.api.order.api.OrderApi;
import com.thoughtworks.ddd.api.order.request.CancelOrderRequest;
import com.thoughtworks.ddd.api.order.request.CreateOrderRequest;
import com.thoughtworks.ddd.api.order.response.CancelOrderResponse;
import com.thoughtworks.ddd.api.order.response.CreateOrderResponse;
import com.thoughtworks.ddd.application.order.command.CancelOrderCmd;
import com.thoughtworks.ddd.application.order.command.CreateOrderCmd;
import com.thoughtworks.ddd.application.order.event.OrderCanceledEvent;
import com.thoughtworks.ddd.application.order.event.OrderCreatedEvent;
import com.thoughtworks.ddd.application.order.service.OrderService;
import com.thoughtworks.ddd.domain.common.AuthUser;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * 把接口的实现类,发布给其他微服务使用
 */
@RestController
public class OrderController implements OrderApi {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public CommonResponse<CreateOrderResponse> createOrder(@RequestBody CreateOrderRequest request) {
        CreateOrderCmd cmd = CreateOrderCmd.builder()
                .goodsId(request.getGoodsId())
                .goodsCnt(request.getGoodsNum())
                .build();
        //应该从session上下文中获取用户
        AuthUser user = new AuthUser();
        OrderCreatedEvent event = orderService.createOrder(cmd, user);
        return CommonResponse.success(new CreateOrderResponse(event.getOrderId()));
    }

    @Override
    public CommonResponse<CancelOrderResponse> cancelOrder(@RequestBody CancelOrderRequest request) {
        CancelOrderCmd cmd = CancelOrderCmd.builder()
                .orderId(request.getOrderId())
                .build();
        //应该从session上下文中获取用户
        AuthUser user = new AuthUser();
        OrderCanceledEvent event = orderService.cancelEvent(cmd, user);
        return CommonResponse.success(new CancelOrderResponse(event.getOrderId()));
    }
}
