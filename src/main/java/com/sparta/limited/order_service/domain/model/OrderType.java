package com.sparta.limited.order_service.domain.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum OrderType {
    AUCTION("경매상품"),
    LIMITED("한정판매상품");

    private final String description;

    public static OrderType from(String orderType) {
        return OrderType.valueOf(orderType);
    }
}
