package com.sparta.limited.order_service.infrastructure.client;

import com.sparta.limited.order_service.infrastructure.client.dto.UserReadResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-service")
public interface UserClient {

    @GetMapping("/api/v1/internal/users/{userId}")
    UserReadResponse getUserByUserId(@PathVariable(name = "userId") Long userId);
}
