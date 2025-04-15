package com.sparta.limited.order_service.domain.exception;

import com.sparta.limited.common_module.exception.ErrorCode;
import lombok.Getter;

@Getter
public enum OrderErrorCode {
    
    // 주문 생성 관련
    DUPLICATE_ORDER(ErrorCode.DUPLICATE_RESOURCE, "이미 주문한 상품입니다.");

    private final ErrorCode errorCode;
    private final String detailMessage;

    OrderErrorCode(ErrorCode errorCode, String detailMessage) {
        this.errorCode = errorCode;
        this.detailMessage = detailMessage;
    }

}
