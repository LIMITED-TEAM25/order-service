package com.sparta.limited.order_service.application.service;

import com.sparta.limited.order_service.application.dto.request.OrderCreateRequest;
import com.sparta.limited.order_service.application.dto.response.OrderCreateResponse;
import com.sparta.limited.order_service.application.dto.response.OrderReadResponse;
import java.util.UUID;

public interface OrderService {

    OrderCreateResponse createOrder(Long userId, OrderCreateRequest request);

    OrderReadResponse getOrder(Long userId, UUID id);
}
