package com.example.plusproject.domain.auth.controller;

import com.example.plusproject.domain.auth.dto.Response.SigninResponse;
import com.example.plusproject.domain.auth.dto.Resquest.SigninRequest;
import com.example.plusproject.domain.auth.dto.Resquest.SignupRequest;
import com.example.plusproject.domain.auth.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/api/v1/auth/signup")
    public ResponseEntity<Void> signup(@Valid @RequestBody SignupRequest signupRequest,
                                       BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(System.out::println);
            return ResponseEntity.badRequest().build();
        }

        authService.signup(signupRequest);

        return ResponseEntity.noContent().build();
    }

    @PostMapping("/api/v1/auth/signin")
    public ResponseEntity<SigninResponse> signin(@Valid @RequestBody SigninRequest signinRequest) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(authService.signin(signinRequest));
    }
}

