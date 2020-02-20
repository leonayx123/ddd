package com.thoughtworks.ddd.domain.order.model;

import com.thoughtworks.ddd.domain.common.BaseException;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class OrderEntity {
    private String orderId;
    private Integer goodsNum;
    private BigDecimal totalPrice;
    private GoodsVo goods;
    private UserVo user;
    private OrderStatus status;

    public void initOrder(GoodsVo goods, Integer goodsNum, UserVo user) {
        this.goods = goods;
        this.user = user;
        this.goodsNum = goodsNum;
        this.totalPrice = cntTotalPrice();
    }

    public BigDecimal cntTotalPrice() {
        return this.goods.getPrice().multiply(BigDecimal.valueOf(this.goodsNum));
    }

    public void CancelOrder() {
        if (status == OrderStatus.CANCELED || status == OrderStatus.OVER) {
            throw new BaseException("can not cancel");
        }
        this.status = OrderStatus.CANCELED;
    }
}
