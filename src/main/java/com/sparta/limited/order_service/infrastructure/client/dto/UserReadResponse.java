package com.sparta.limited.order_service.infrastructure.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class UserReadResponse {

    @JsonProperty("id")
    private final Long userId;
    private final String username;
    private final String address;

    public UserReadResponse(Long userId, String username, String address) {
        this.userId = userId;
        this.username = username;
        this.address = address;
    }

}
