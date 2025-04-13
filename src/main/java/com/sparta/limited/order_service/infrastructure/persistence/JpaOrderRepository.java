package com.sparta.limited.order_service.infrastructure.persistence;

import com.sparta.limited.order_service.domain.model.Order;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaOrderRepository extends JpaRepository<Order, UUID> {
    
    Optional<Order> findById(UUID id);
}
