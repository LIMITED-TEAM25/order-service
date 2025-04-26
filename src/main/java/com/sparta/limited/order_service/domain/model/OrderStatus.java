package com.sparta.limited.order_service.domain.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum OrderStatus {
    CONFIRMED("주문완료"),
    PAID("결제완료"),
    CANCELED("주문취소");

    private final String description;

    public static OrderStatus from(String status) {
        return OrderStatus.valueOf(status);
    }


}
