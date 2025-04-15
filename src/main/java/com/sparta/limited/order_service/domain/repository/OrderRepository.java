package com.sparta.limited.order_service.domain.repository;

import com.sparta.limited.order_service.domain.model.Order;
import java.util.UUID;

public interface OrderRepository {

    void save(Order order);

    Order findById(UUID id);

    boolean existsByUserIdAndProductId(Long userId, UUID productId);
}
