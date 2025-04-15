package com.sparta.limited.order_service.infrastructure.client.dto;

import lombok.Getter;

@Getter
public class UserReadResponse {

    private final String username;
    private final String address;

    public UserReadResponse(String username, String address) {
        this.username = username;
        this.address = address;
    }

}
