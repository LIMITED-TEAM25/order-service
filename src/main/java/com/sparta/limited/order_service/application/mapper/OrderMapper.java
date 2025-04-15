package com.sparta.limited.order_service.application.mapper;

import com.sparta.limited.order_service.application.dto.request.OrderCreateRequest;
import com.sparta.limited.order_service.application.dto.response.OrderCreateResponse;
import com.sparta.limited.order_service.application.service.user.UserInfo;
import com.sparta.limited.order_service.domain.model.Order;

public class OrderMapper {

    public static Order toEntity(Long userId, OrderCreateRequest request, UserInfo userInfo) {
        return Order.of(userId, userInfo.username(), userInfo.address(),
            request.getOrderType(), request.getProductId(),
            request.getQuantity(), request.getPrice());
    }

    public static OrderCreateResponse toResponse(Order order) {
        return OrderCreateResponse.of(order.getId(), order.getUserId(), order.getUsername(),
            order.getAddress(), order.getOrderType(),
            order.getStatus(),
            order.getProductId(),
            order.getQuantity(), order.getPrice());
    }
}
