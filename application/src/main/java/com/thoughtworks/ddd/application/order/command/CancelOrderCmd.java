package com.thoughtworks.ddd.application.order.command;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CancelOrderCmd {
    private String orderId;
}
