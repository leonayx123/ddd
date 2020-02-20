package com.thoughtworks.ddd.application.order.command;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CancelOrderCmd {
    private String orderId;
}
