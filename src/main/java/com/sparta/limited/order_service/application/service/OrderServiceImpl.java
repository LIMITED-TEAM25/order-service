package com.sparta.limited.order_service.application.service;

import com.sparta.limited.order_service.application.dto.request.OrderCreateRequest;
import com.sparta.limited.order_service.application.dto.response.OrderCreateResponse;
import com.sparta.limited.order_service.application.mapper.OrderMapper;
import com.sparta.limited.order_service.domain.model.Order;
import com.sparta.limited.order_service.domain.repository.OrderRepository;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Transactional
    public OrderCreateResponse createOrder(OrderCreateRequest request) {
        Order order = OrderMapper.toEntity(request);
        orderRepository.save(order);
        return OrderMapper.toResponse(order);
    }

    public OrderCreateResponse getOrder(UUID id) {
        Order order = orderRepository.findById(id);
        return OrderMapper.toResponse(order);
    }

}
