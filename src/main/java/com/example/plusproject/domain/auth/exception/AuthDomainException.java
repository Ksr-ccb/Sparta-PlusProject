package com.example.plusproject.domain.auth.exception;

import com.example.plusproject.global.exception.BaseException;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class AuthDomainException extends BaseException {
    private final AuthExceptionCode errorCode;
    private final HttpStatus httpStatus;
    private final String message;

    public AuthDomainException(AuthExceptionCode errorCode) {
        this.errorCode = errorCode;
        this.httpStatus = errorCode.getHttpStatus();
        this.message = errorCode.getMessage();
    }
}