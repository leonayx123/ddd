package com.thoughtworks.user.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class UpdateUserRequest {
    @NotBlank
    private String id;
    private String name;
}
