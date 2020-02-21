package com.thoughtworks.ddd.api.order.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@ApiModel(value = "CreateOrderRequest")
@Getter
@Setter
public class CreateOrderRequest {

    @ApiModelProperty(value = "goodsId", name = "goodsId", notes = "商品id")
    @NotBlank(message = "goodsId can not be blank")
    private String goodsId;

    @ApiModelProperty(value = "goodsNum", name = "goodsNum", notes = "商品数量")
    private Integer goodsNum;
}
