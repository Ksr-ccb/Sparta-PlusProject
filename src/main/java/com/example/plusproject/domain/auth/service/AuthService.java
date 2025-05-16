package com.example.plusproject.domain.auth.service;


import com.example.plusproject.domain.auth.dto.Response.SigninResponse;
import com.example.plusproject.domain.auth.dto.Resquest.SigninRequest;
import com.example.plusproject.domain.auth.dto.Resquest.SignupRequest;
import com.example.plusproject.domain.auth.exception.AuthDomainException;
import com.example.plusproject.domain.auth.exception.AuthExceptionCode;
import com.example.plusproject.domain.user.entity.User;
import com.example.plusproject.domain.user.enums.UserRole;
import com.example.plusproject.domain.user.repository.UserRepository;
import com.example.plusproject.global.config.JwtUtil;
import com.example.plusproject.global.config.PasswordEncoder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    @Transactional
    public void signup(SignupRequest signupRequest) {

        if (userRepository.existsByEmail(signupRequest.getEmail())) {
            throw new AuthDomainException(AuthExceptionCode.DUPLICATE_EMAIL);
        }

        String encodedPassword = passwordEncoder.encode(signupRequest.getPassword());

        UserRole userRole = UserRole.of(signupRequest.getRole());

        User newUser = new User(
                signupRequest.getEmail(),
                signupRequest.getName(),
                encodedPassword,
                userRole
        );
        userRepository.save(newUser);
    }

    @Transactional
    public SigninResponse signin(SigninRequest signinRequest) {
        User user = userRepository.findByEmail(signinRequest.getEmail()).orElseThrow(
                () -> new AuthDomainException(AuthExceptionCode.NOT_REGISTER_USER));
        // 로그인 시 이메일과 비밀번호가 일치하지 않을 경우 401을 반환합니다.
        if (!passwordEncoder.matches(signinRequest.getPassword(), user.getPassword())) {
            throw new AuthDomainException(AuthExceptionCode.WRONG_PASSWORD);
        }

        String bearerToken = jwtUtil.createToken(user.getId(), user.getEmail(), user.getNickname(), user.getUserRole());

        return new SigninResponse(bearerToken);
    }
}
