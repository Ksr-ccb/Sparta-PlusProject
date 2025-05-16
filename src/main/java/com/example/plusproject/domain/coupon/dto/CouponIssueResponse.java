package com.example.plusproject.domain.coupon.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
@Builder
public class CouponIssueResponse {

    private final Long couponIssuedId;
    private final Long userId;
    private final Long couponId;
    private final LocalDateTime issuedAt;

}

//{
//	couponIssuedId : 1,
//	userId: 1,
//	couponId: 1,
//	issuedAt: 2025/05/16 11:09(LocalDateTime)
//}
