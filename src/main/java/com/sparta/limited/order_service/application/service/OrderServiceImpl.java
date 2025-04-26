package com.sparta.limited.order_service.application.service;

import com.sparta.limited.order_service.application.dto.request.OrderCreateRequest;
import com.sparta.limited.order_service.application.dto.response.OrderCreateResponse;
import com.sparta.limited.order_service.application.dto.response.OrderReadResponse;
import com.sparta.limited.order_service.application.mapper.OrderMapper;
import com.sparta.limited.order_service.application.service.user.UserClientService;
import com.sparta.limited.order_service.application.service.user.UserInfo;
import com.sparta.limited.order_service.domain.model.Order;
import com.sparta.limited.order_service.domain.repository.OrderRepository;
import com.sparta.limited.order_service.domain.validator.OrderValidator;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final UserClientService userClientService;
    private final OrderValidator orderValidator;

    @Transactional
    public OrderCreateResponse createOrder(Long userId, OrderCreateRequest request) {
        log.info("orderType: " + request.getOrderType());
        orderValidator.validateNoDuplicateOrder(userId, request.getProductId(),
            request.getOrderType());
        UserInfo userInfo = userClientService.getUserByUserId(userId);
        Order order = OrderMapper.toEntity(userId, request, userInfo);
        orderRepository.save(order);
        return OrderMapper.toResponse(order);
    }

    public OrderReadResponse getOrder(Long userId, UUID id) {
        Order order = orderRepository.findById(id);
        OrderValidator.validateOrderAccess(order, userId);
        return OrderMapper.toReadResponse(order);
    }

}
