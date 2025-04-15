package com.sparta.limited.order_service.domain.validator;

import com.sparta.limited.common_module.exception.BusinessException;
import com.sparta.limited.common_module.exception.ErrorCode;
import com.sparta.limited.order_service.domain.repository.OrderRepository;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderValidator {

    private final OrderRepository orderRepository;

    public void validateNoDuplicateOrder(Long userId, UUID productId) {
        if (orderRepository.existsByUserIdAndProductId(userId, productId)) {
            throw new BusinessException(ErrorCode.DUPLICATE_RESOURCE, "이미 주문한 상품입니다.");
        }
    }

}
