package com.sparta.limited.order_service.presentation.controller;

import com.sparta.limited.common_module.common.aop.RoleCheck;
import com.sparta.limited.order_service.application.dto.request.OrderCreateRequest;
import com.sparta.limited.order_service.application.dto.response.OrderCreateResponse;
import com.sparta.limited.order_service.application.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/internal/orders")
public class OrderInternalController {

    private final OrderService orderService;

    @RoleCheck("ROLE_USER")
    @PostMapping
    ResponseEntity<OrderCreateResponse> createOrder(
        @RequestHeader("X-User-Id") Long userId,
        @RequestBody OrderCreateRequest request) {
        OrderCreateResponse response = orderService.createOrder(userId, request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
