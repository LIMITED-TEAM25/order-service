package com.sparta.limited.order_service.application.mapper;

import com.sparta.limited.order_service.application.dto.request.OrderCreateRequest;
import com.sparta.limited.order_service.application.dto.response.OrderCreateResponse;
import com.sparta.limited.order_service.domain.model.Order;

public class OrderMapper {

    public static Order toEntity(OrderCreateRequest request) {
        return Order.of(request.getUserId(), request.getOrderType(), request.getProductId(),
            request.getQuantity(), request.getPrice());
    }

    public static OrderCreateResponse toResponse(Order order) {
        return OrderCreateResponse.of(order.getId(), order.getUserId(), order.getOrderType(),
            order.getStatus(),
            order.getProductId(),
            order.getQuantity(), order.getPrice());
    }
}
