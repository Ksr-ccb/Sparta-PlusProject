package com.example.plusproject.domain.coupon.controller;

import com.example.plusproject.domain.coupon.dto.CouponIssueResponse;
import com.example.plusproject.domain.coupon.service.CouponService;
import com.example.plusproject.global.common.dto.AuthUser;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CouponController {

    private final CouponService couponService;

    @PostMapping("/api/v1/coupon/{couponId}/issue")
    public ResponseEntity<CouponIssueResponse> CouponIssue(
            @PathVariable Long couponId,
            @AuthenticationPrincipal AuthUser authUser
            ){
        return ResponseEntity.status(HttpStatus.OK).body(couponService.CouponIssue(authUser, couponId));
    }

}
