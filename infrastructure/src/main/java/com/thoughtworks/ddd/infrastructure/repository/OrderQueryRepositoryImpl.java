package com.thoughtworks.ddd.infrastructure.repository;

import com.thoughtworks.ddd.query.order.condition.QueryCondition;
import com.thoughtworks.ddd.query.order.dto.OrderInfoDto;
import com.thoughtworks.ddd.query.order.repository.OrderQueryRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class OrderQueryRepositoryImpl implements OrderQueryRepository {
    @Override
    public List<OrderInfoDto> queryOrders(QueryCondition condition, Pageable page) {
        return Collections.emptyList();
    }
}
