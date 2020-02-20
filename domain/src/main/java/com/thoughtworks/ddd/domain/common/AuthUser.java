package com.thoughtworks.ddd.domain.common;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthUser {
    private String userId;
    private String userName;
    private String loginName;
    private String phone;
    private String address;
}
