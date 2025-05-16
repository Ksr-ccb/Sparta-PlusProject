package com.example.plusproject.domain.user.enums;


import com.example.plusproject.domain.user.exception.UserException;
import com.example.plusproject.domain.user.exception.UserExceptionCode;

import java.util.Arrays;

public enum UserRole {
    ADMIN, USER;

    public static UserRole of(String role) {
        return Arrays.stream(UserRole.values())
                .filter(r -> r.name().equalsIgnoreCase(role))
                .findFirst()
                .orElseThrow(() -> new UserException(UserExceptionCode.INVALID_USER_ROLE));
    }
}
