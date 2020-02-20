package com.thoughtworks.ddd.query.order.repository;

import com.thoughtworks.ddd.query.order.condition.QueryCondition;
import com.thoughtworks.ddd.query.order.dto.OrderInfoDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface OrderQueryRepository {

    /**
     * 根据查询条件查询订单
     * @param condition
     * @param page
     * @return
     */
    List<OrderInfoDto> queryOrders(QueryCondition condition, Pageable page);
}
