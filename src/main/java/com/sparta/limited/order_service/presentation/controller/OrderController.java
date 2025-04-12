package com.sparta.limited.order_service.presentation.controller;

import com.sparta.limited.order_service.application.dto.request.OrderCreateRequest;
import com.sparta.limited.order_service.application.dto.response.OrderCreateResponse;
import com.sparta.limited.order_service.application.service.OrderService;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/orders")
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    ResponseEntity<OrderCreateResponse> createOrder(
        @RequestBody OrderCreateRequest request) {
        OrderCreateResponse response = orderService.createOrder(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    ResponseEntity<OrderCreateResponse> getOrder(@PathVariable("id") UUID id) {
        OrderCreateResponse response = orderService.getOrder(id);
        return ResponseEntity.ok(response);
    }
}
