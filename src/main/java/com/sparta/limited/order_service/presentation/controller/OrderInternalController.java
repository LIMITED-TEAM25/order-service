package com.sparta.limited.order_service.presentation.controller;

import com.sparta.limited.order_service.application.dto.request.OrderCreateRequest;
import com.sparta.limited.order_service.application.dto.response.OrderCreateResponse;
import com.sparta.limited.order_service.application.service.OrderService;
import java.net.URI;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/internal/orders")
public class OrderInternalController {

    private final OrderService orderService;

    @PostMapping
    ResponseEntity<OrderCreateResponse> createOrder(
        @RequestHeader("X-User-Id") Long userId,
        @RequestBody OrderCreateRequest request) {
        OrderCreateResponse response = orderService.createOrder(userId, request);

        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath()
            .path("/api/v1/internal/orders/{id}")
            .buildAndExpand(response.getId())
            .toUri();

        return ResponseEntity.created(uri).body(response);
    }

}
