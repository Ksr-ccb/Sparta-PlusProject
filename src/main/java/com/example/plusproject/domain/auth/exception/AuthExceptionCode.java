package com.example.plusproject.domain.auth.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
@Getter
public enum AuthExceptionCode {

    DUPLICATE_EMAIL(false, HttpStatus.BAD_REQUEST, "이미 존재하는 이메일입니다."),
    WRONG_PASSWORD(false, HttpStatus.BAD_REQUEST, "잘못된 비밀번호입니다."),
    NOT_REGISTER_USER(false, HttpStatus.FOUND, "가입되지 않은 유저입니다.");

    private final boolean isSuccess;
    private final HttpStatus httpStatus;
    private final String message;
}
