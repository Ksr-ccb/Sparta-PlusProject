package com.example.plusproject.global.common.exception;

import com.example.plusproject.global.exception.BaseException;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class CommonException extends BaseException {
    private final CommonExceptionCode errorCode;
    private final HttpStatus httpStatus;
    private final String message;

    public CommonException(CommonExceptionCode errorCode) {
        this.errorCode = errorCode;
        this.httpStatus = errorCode.getHttpStatus();
        this.message = errorCode.getMessage();
    }
}
