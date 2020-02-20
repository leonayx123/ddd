package com.thoughtworks.ddd.infrastructure.repo;

import com.thoughtworks.ddd.infrastructure.po.OrderPo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository<OrderPo, String>, QuerydslPredicateExecutor<OrderPo> {
}
