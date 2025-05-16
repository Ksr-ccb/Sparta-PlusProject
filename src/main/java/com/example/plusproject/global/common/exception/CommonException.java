package com.example.plusproject.global.common.exception;

import com.example.plusproject.domain.user.exception.UserExceptionCode;
import com.example.plusproject.global.exception.BaseException;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class CommonException extends BaseException {
    private final UserExceptionCode errorCode;
    private final HttpStatus httpStatus;
    private final String message;

    public CommonException(UserExceptionCode errorCode) {
        this.errorCode = errorCode;
        this.httpStatus = errorCode.getHttpStatus();
        this.message = errorCode.getMessage();
    }
}