package com.sparta.limited.order_service.infrastructure.persistence;

import com.sparta.limited.order_service.domain.model.Order;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaOrderRepository extends JpaRepository<Order, UUID> {

}
