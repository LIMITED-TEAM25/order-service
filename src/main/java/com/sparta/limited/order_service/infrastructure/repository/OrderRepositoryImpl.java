package com.sparta.limited.order_service.infrastructure.repository;

import com.sparta.limited.common_module.exception.BusinessException;
import com.sparta.limited.common_module.exception.ErrorCode;
import com.sparta.limited.order_service.domain.model.Order;
import com.sparta.limited.order_service.domain.repository.OrderRepository;
import com.sparta.limited.order_service.infrastructure.persistence.JpaOrderRepository;
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
    public Order findById(UUID id) {
        return jpaOrderRepository.findById(id)
            .orElseThrow(() -> new BusinessException(ErrorCode.RESOURCES_NOT_FOUND));
    }

    @Override
    public boolean existsByUserIdAndProductId(Long userId, UUID productId) {
        return jpaOrderRepository.existsByUserIdAndProductId(userId, productId);
    }
}
