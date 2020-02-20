package com.thoughtworks.ddd.domain.order.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserVo {
    private String id;
    private String loginName;
    private String name;
    private String phone;
    private String address;
}
