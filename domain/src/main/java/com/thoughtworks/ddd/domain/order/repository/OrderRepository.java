package com.thoughtworks.ddd.domain.order.repository;

import com.thoughtworks.ddd.domain.order.model.OrderEntity;

public interface OrderRepository {

    OrderEntity getOrderEntity(String id);

    OrderEntity createOrder(OrderEntity orderEntity);

    void cancelOrder(OrderEntity orderEntity);
}
