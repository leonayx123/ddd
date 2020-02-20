package com.thoughtworks.ddd.domain.order.model;

import lombok.Getter;

@Getter
public enum OrderStatus {
    CREATED(10), PAYED(20), DELIVERY(30), CANCELED(40), OVER(90);

    private Integer status;

    OrderStatus(Integer status) {
        this.status = status;
    }
}
