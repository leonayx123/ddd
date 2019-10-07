package com.thoughtworks.user.api;

import com.thoughtworks.user.request.UpdateUserRequest;
import com.thoughtworks.user.response.UpdateUserResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface UserApi {

    @PostMapping("/user/update")
    UpdateUserResponse updateUser(@RequestBody UpdateUserRequest request);

    @GetMapping("/user/update")
    UpdateUserResponse updateUserGet(UpdateUserRequest request);
}
