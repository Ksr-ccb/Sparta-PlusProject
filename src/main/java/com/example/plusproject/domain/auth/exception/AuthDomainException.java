package com.example.plusproject.domain.auth.exception;

import com.example.plusproject.domain.user.exception.UserExceptionCode;
import com.example.plusproject.global.exception.BaseException;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class AuthException extends BaseException {
    private final AuthExceptionCode errorCode;
    private final HttpStatus httpStatus;
    private final String message;

    public AuthException(AuthExceptionCode errorCode) {
        this.errorCode = errorCode;
        this.httpStatus = errorCode.getHttpStatus();
        this.message = errorCode.getMessage();
    }
}