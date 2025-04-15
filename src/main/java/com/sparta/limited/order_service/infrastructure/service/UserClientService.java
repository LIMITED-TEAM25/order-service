package com.sparta.limited.order_service.infrastructure.service;

import com.sparta.limited.order_service.infrastructure.client.UserClient;
import com.sparta.limited.order_service.infrastructure.client.dto.UserInfo;
import com.sparta.limited.order_service.infrastructure.client.dto.UserReadResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserClientService {

    private final UserClient userClient;

    public UserInfo getUserByUserId(Long userId) {
        UserReadResponse response = userClient.getUserByUserId(userId);
        return UserInfo.from(
            response.getUsername(),
            response.getAddress()
        );
    }

}
