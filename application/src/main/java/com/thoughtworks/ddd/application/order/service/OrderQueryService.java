package com.thoughtworks.ddd.application.order.service;

import com.thoughtworks.ddd.query.order.condition.QueryCondition;
import com.thoughtworks.ddd.query.order.dto.OrderInfoDto;
import com.thoughtworks.ddd.query.order.repository.OrderQueryRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderQueryService {
    private final OrderQueryRepository queryOrderRepository;

    public OrderQueryService(OrderQueryRepository queryOrderRepository) {
        this.queryOrderRepository = queryOrderRepository;
    }


    List<OrderInfoDto> queryOrderList(QueryCondition condition, Pageable pageable) {
        return queryOrderRepository.queryOrders(condition, pageable);
    }
}
