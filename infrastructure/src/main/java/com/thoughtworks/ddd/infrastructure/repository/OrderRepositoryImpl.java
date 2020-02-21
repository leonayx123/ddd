package com.thoughtworks.ddd.infrastructure.repository;

import com.thoughtworks.ddd.domain.order.model.OrderEntity;
import com.thoughtworks.ddd.domain.order.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderRepositoryImpl implements OrderRepository {

    @Override
    public OrderEntity getOrderEntity(String id) {
        return null;
    }

    @Override
    public OrderEntity createOrder(OrderEntity orderEntity) {
        return null;
    }

    @Override
    public void cancelOrder(OrderEntity orderEntity) {

    }
}
