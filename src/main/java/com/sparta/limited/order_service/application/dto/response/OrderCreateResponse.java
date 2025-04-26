package com.sparta.limited.order_service.application.dto.response;

import com.sparta.limited.order_service.domain.model.OrderStatus;
import com.sparta.limited.order_service.domain.model.OrderType;
import java.math.BigDecimal;
import java.util.UUID;
import lombok.Getter;

@Getter
public class OrderCreateResponse {

    private UUID id;
    private Long userId;
    private String username;
    private String address;
    private OrderType orderType;
    private OrderStatus status;
    private UUID productId;
    private int quantity;
    private BigDecimal price;

    private OrderCreateResponse(UUID id, Long userId, String username, String address,
        OrderType orderType, OrderStatus status,
        UUID productId, int quantity, BigDecimal price) {
        this.id = id;
        this.userId = userId;
        this.username = username;
        this.address = address;
        this.orderType = orderType;
        this.status = status;
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
    }

    public static OrderCreateResponse of(UUID id, Long userId, String username, String address,
        OrderType orderType,
        OrderStatus status,
        UUID productId, int quantity, BigDecimal price) {
        return new OrderCreateResponse(id, userId, username, address, orderType, status, productId,
            quantity, price);
    }
}
