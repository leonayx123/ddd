package com.thoughtworks.ddd.infrastructure.po;

import com.thoughtworks.ddd.infrastructure.common.BasePo;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "t_jx_order")
@Getter
@Setter
public class OrderPo extends BasePo {
    @Column(name="order_no")
    private String orderNo;

    @Column(name="total_price")
    private BigDecimal totalPrice;

    @Column(name="discount")
    private BigDecimal discount;

    @Column(name="pay_price")
    private BigDecimal payPrice;

    @Column(name="user_id")
    private String userId;

    @Column(name="user_name")
    private String userName;

    @Column(name="phone")
    private String phone;

    @Column(name="address")
    private String address;

    @Column(name="goods_id")
    private String goodsId;

    @Column(name="goods_name")
    private String goodsName;

    @Column(name="goods_price")
    private BigDecimal goodsPrice;

}
