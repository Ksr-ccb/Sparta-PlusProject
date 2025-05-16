package com.example.plusproject.global.common.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;


@Getter
@RequiredArgsConstructor
public enum CommonExceptionCode {

    NOT_FOUND_TOKEN(false, HttpStatus.NOT_FOUND,"Not Found Token");


    private final boolean isSuccess;
    private final HttpStatus httpStatus;
    private final String message;

}
