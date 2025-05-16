package com.example.plusproject.domain.auth.controller;

import com.example.plusproject.domain.auth.dto.Response.SigninResponse;
import com.example.plusproject.domain.auth.dto.Resquest.SigninRequest;
import com.example.plusproject.domain.auth.dto.Resquest.SignupRequest;
import com.example.plusproject.domain.auth.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/auth/signup")
    public ResponseEntity<Void> signup(@Valid @RequestBody SignupRequest signupRequest) {
        System.out.println("in controller");
        authService.signup(signupRequest);

        return (ResponseEntity<Void>) ResponseEntity.status(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/auth/signin")
    public ResponseEntity<SigninResponse> signin(@Valid @RequestBody SigninRequest signinRequest) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(authService.signin(signinRequest));
    }
}

