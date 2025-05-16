package com.example.plusproject.domain.coupon.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum CouponExceptionCode {

    NOT_FOUND_COUPON(false, HttpStatus.NOT_FOUND, "해당 쿠폰을 찾을 수 없습니다"),
    COUPON_OUT_OF_STOCK(false, HttpStatus.GONE, "준비된 쿠폰이 모두 소진되었습니다. 다음 기회에 다시 참여해주세요");

    private final boolean isSuccess;
    private final HttpStatus httpStatus;
    private final String message;
}
