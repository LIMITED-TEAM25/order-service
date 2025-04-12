package com.sparta.limited.order_service.domain.model;

import com.sparta.limited.common_module.common.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "p_order")
public class Order extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private Long userId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OrderType orderType;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OrderStatus status;

    @Column(nullable = false)
    private UUID productId;

    @Column(nullable = false)
    private int quantity;

    @Column(precision = 10, scale = 2, nullable = false)
    private BigDecimal price;

    private Order(Long userId, OrderType orderType, UUID productId, int quantity,
        BigDecimal price) {
        this.userId = userId;
        this.orderType = orderType;
        this.status = OrderStatus.CONFIRMED;
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
    }

    public static Order of(Long userId, OrderType orderType, UUID productId,
        int quantity, BigDecimal price) {
        return new Order(userId, orderType, productId, quantity, price);
    }

}
