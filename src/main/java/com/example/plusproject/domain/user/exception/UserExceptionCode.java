package com.example.plusproject.domain.user.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum UserExceptionCode {

    INVALID_USER_ROLE(false, HttpStatus.BAD_REQUEST, "유효하지 않는 User_Role");

    private final boolean isSuccess;
    private final HttpStatus httpStatus;
    private final String message;
}
