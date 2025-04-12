package com.sparta.limited.order_service.application.dto.request;

import com.sparta.limited.order_service.domain.model.OrderType;
import java.math.BigDecimal;
import java.util.UUID;
import lombok.Getter;

@Getter
public class OrderCreateRequest {

    private Long userId;
    private OrderType orderType;
    private UUID productId;
    private int quantity;
    private BigDecimal price;
}
