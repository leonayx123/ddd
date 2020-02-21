package com.thoughtworks.ddd.api.order.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@ApiModel
@Setter
@Getter
public class CancelOrderRequest {

    @ApiModelProperty(value = "orderId", name = "orderId", notes = "待撤销订单id")
    @NotBlank(message = "orderId can not be blank")
    private String orderId;
}
