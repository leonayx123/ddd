package com.thoughtworks.ddd.api.order.response;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Api
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CancelOrderResponse {

    @ApiModelProperty(name = "orderId")
    private String orderId;
}
