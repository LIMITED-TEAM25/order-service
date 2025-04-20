package com.sparta.limited.order_service.domain.validator;

import com.sparta.limited.common_module.exception.BusinessException;
import com.sparta.limited.common_module.exception.ErrorCode;
import com.sparta.limited.order_service.domain.model.Order;
import com.sparta.limited.order_service.domain.model.OrderType;
import com.sparta.limited.order_service.domain.repository.OrderRepository;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderValidator {

    private final OrderRepository orderRepository;

    public static void validateOrderAccess(Order order, Long userId) {
        if (!order.getUserId().equals(userId)) {
            throw new BusinessException(ErrorCode.UNMATCHED_USER_DATA, "해당 주문에 접근 권한이 없습니다.");
        }
    }

    public void validateNoDuplicateOrder(Long userId, UUID productId, OrderType orderType) {
        if (OrderType.AUCTION.equals(orderType) &&
            orderRepository.existsByUserIdAndProductIdAndOrderType(userId, productId,
                OrderType.AUCTION)) {
            throw new BusinessException(ErrorCode.DUPLICATE_RESOURCE, "이미 주문한 경매 상품입니다.");
        }
    }

}
