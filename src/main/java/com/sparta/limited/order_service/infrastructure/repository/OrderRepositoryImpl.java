package com.sparta.limited.order_service.infrastructure.repository;

import com.sparta.limited.order_service.domain.model.Order;
import com.sparta.limited.order_service.domain.repository.OrderRepository;
import com.sparta.limited.order_service.infrastructure.persistence.JpaOrderRepository;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryImpl implements OrderRepository {

    private final JpaOrderRepository jpaOrderRepository;

    @Override
    public void save(Order order) {
        jpaOrderRepository.save(order);
    }

    @Override
    public Optional<Order> findById(UUID id) {
        return jpaOrderRepository.findById(id);
    }
}
