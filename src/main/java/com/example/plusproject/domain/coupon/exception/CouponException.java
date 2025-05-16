package com.example.plusproject.domain.coupon.exception;

import com.example.plusproject.domain.user.exception.UserExceptionCode;
import com.example.plusproject.global.exception.BaseException;
import lombok.Getter;
import org.springframework.http.HttpStatus;


@Getter
public class CouponException extends BaseException {
    private final CouponExceptionCode errorCode;
    private final HttpStatus httpStatus;
    private final String message;

    public CouponException(CouponExceptionCode errorCode) {
        this.errorCode = errorCode;
        this.httpStatus = errorCode.getHttpStatus();
        this.message = errorCode.getMessage();
    }
}