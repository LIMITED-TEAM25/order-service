package com.sparta.limited.order_service.application.service;

import com.sparta.limited.order_service.application.dto.request.OrderCreateRequest;
import com.sparta.limited.order_service.application.dto.response.OrderCreateResponse;
import java.util.UUID;

public interface OrderService {

    OrderCreateResponse createOrder(OrderCreateRequest request);

    OrderCreateResponse getOrder(UUID id);
}
