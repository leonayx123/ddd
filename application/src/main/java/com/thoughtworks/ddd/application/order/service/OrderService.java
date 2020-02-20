package com.thoughtworks.ddd.application.order.service;

import com.thoughtworks.ddd.application.order.command.CancelOrderCmd;
import com.thoughtworks.ddd.application.order.command.CreateOrderCmd;
import com.thoughtworks.ddd.application.order.event.OrderCanceledEvent;
import com.thoughtworks.ddd.application.order.event.OrderCreatedEvent;
import com.thoughtworks.ddd.domain.common.AuthUser;
import com.thoughtworks.ddd.domain.order.model.GoodsVo;
import com.thoughtworks.ddd.domain.order.model.OrderEntity;
import com.thoughtworks.ddd.domain.order.model.UserVo;
import com.thoughtworks.ddd.domain.order.repository.OrderRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final ApplicationEventPublisher eventPublisher;
    private final OrderRepository orderRepository;

    public OrderService(ApplicationEventPublisher eventPublisher, OrderRepository orderRepository) {
        this.eventPublisher = eventPublisher;
        this.orderRepository = orderRepository;
    }

    /**
     * 创建订单
     *
     * @param cmd
     * @param authUser
     * @return
     */
    public OrderCreatedEvent createOrder(CreateOrderCmd cmd, AuthUser authUser) {
        GoodsVo goodsVo = getGoodsVoFromCmd(cmd);

        UserVo userVo = getUserVoFromCmd(authUser);

        OrderEntity entity = new OrderEntity();
        entity.initOrder(goodsVo, cmd.getGoodsCnt(), userVo);

        orderRepository.createOrder(entity);

        OrderCreatedEvent createdEvent = new OrderCreatedEvent();
        eventPublisher.publishEvent(createdEvent);
        return createdEvent;
    }

    /**
     * 撤销订单
     *
     * @param cmd
     * @param authUser
     * @return
     */
    public OrderCanceledEvent cancelEvent(CancelOrderCmd cmd, AuthUser authUser) {
        OrderEntity orderEntity = orderRepository.getOrderEntity(cmd.getOrderId());

        orderRepository.cancelOrder(orderEntity);

        OrderCanceledEvent event = new OrderCanceledEvent();
        eventPublisher.publishEvent(event);
        return event;
    }

    private UserVo getUserVoFromCmd(AuthUser authUser) {
        return UserVo.builder()
                .id(authUser.getUserId())
                .loginName(authUser.getLoginName())
                .address(authUser.getAddress())
                .phone(authUser.getPhone()).build();
    }

    private GoodsVo getGoodsVoFromCmd(CreateOrderCmd cmd) {
        return GoodsVo.builder()
                .id(cmd.getGoodsId())
                .name(cmd.getGoodsName())
                .price(cmd.getGoodPrice()).build();
    }
}
