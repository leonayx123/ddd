package com.thoughtworks.ddd.query.order.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class OrderInfoDto {
    private String orderId;
    private String orderName;
    private String picUrl;
    private BigDecimal price;
}
