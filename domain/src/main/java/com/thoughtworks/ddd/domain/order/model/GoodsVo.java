package com.thoughtworks.ddd.domain.order.model;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GoodsVo {
    private String id;
    private String name;
    private BigDecimal price;
}
