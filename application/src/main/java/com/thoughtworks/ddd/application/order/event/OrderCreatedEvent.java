package com.thoughtworks.ddd.application.order.event;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderCreatedEvent {
    private String orderId;
    private String createdDate;
}
