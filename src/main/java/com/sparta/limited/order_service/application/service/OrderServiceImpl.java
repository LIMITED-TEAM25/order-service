package com.sparta.limited.order_service.application.service;

import com.sparta.limited.common_module.exception.BusinessException;
import com.sparta.limited.common_module.exception.ErrorCode;
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
    private final OrderMapper orderMapper;

    @Transactional
    public OrderCreateResponse createOrder(OrderCreateRequest request) {
        Order order = orderMapper.toEntity(request);
        orderRepository.save(order);
        return orderMapper.toResponse(order);
    }

    public OrderCreateResponse getOrder(UUID id) {
        Order order = orderRepository.findById(id)
            .orElseThrow(() -> new BusinessException(ErrorCode.RESOURCES_NOT_FOUND));
        return orderMapper.toResponse(order);
    }

}
