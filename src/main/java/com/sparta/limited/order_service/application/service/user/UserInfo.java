package com.sparta.limited.order_service.application.service.user;

public record UserInfo(
    String username,
    String address
) {

    public static UserInfo from(String username, String address) {
        return new UserInfo(username, address);
    }

}
