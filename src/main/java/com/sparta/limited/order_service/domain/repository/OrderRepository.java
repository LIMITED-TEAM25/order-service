package com.sparta.limited.order_service.domain.repository;

import com.sparta.limited.order_service.domain.model.Order;
import java.util.Optional;
import java.util.UUID;

public interface OrderRepository {

    void save(Order order);

    Optional<Order> findById(UUID id);
}
