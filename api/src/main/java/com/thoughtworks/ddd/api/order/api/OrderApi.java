package com.thoughtworks.ddd.api.order.api;

import com.thoughtworks.ddd.api.common.CommonResponse;
import com.thoughtworks.ddd.api.order.request.CancelOrderRequest;
import com.thoughtworks.ddd.api.order.request.CreateOrderRequest;
import com.thoughtworks.ddd.api.order.response.CancelOrderResponse;
import com.thoughtworks.ddd.api.order.response.CreateOrderResponse;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 把接口定义成api,发布给其他微服务使用
 */
@FeignClient(name = "OrderApi")
@RestController
@RequestMapping("/v1/service/order")
public interface OrderApi {

    @PostMapping(value = "/createOrder")
    CommonResponse<CreateOrderResponse> createOrder(@RequestBody CreateOrderRequest request);

    @PostMapping(value = "/cancelOrder")
    CommonResponse<CancelOrderResponse> cancelOrder(@RequestBody CancelOrderRequest request);
}
