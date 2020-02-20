package com.thoughtworks.ddd.api.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class CommonResponse<T> {
    private boolean success;
    private String message;
    private Integer code;
    private T result;


    public static CommonResponse fail(Integer code, String message) {
        return CommonResponse.builder().code(code).message(message).success(false).build();
    }

    public static CommonResponse success(Object data) {
        return CommonResponse.builder().code(200)
                .message("请求成功")
                .success(true)
                .result(data)
                .build();
    }
}
