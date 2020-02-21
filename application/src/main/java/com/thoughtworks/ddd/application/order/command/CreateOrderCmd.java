package com.thoughtworks.ddd.application.order.command;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
public class CreateOrderCmd {
    private String orderId;
    private String goodsId;
    private BigDecimal goodPrice;
    private String goodsName;
    private Integer goodsCnt;
    private BigDecimal totalPrice;
}
