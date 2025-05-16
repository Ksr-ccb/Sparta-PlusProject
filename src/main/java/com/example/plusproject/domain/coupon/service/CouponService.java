package com.example.plusproject.domain.coupon.service;


import com.example.plusproject.domain.coupon.dto.CouponIssueResponse;
import com.example.plusproject.domain.coupon.entity.Coupon;
import com.example.plusproject.domain.coupon.entity.CouponHistory;
import com.example.plusproject.domain.coupon.exception.CouponException;
import com.example.plusproject.domain.coupon.exception.CouponExceptionCode;
import com.example.plusproject.domain.coupon.repository.CouponHistoryRepository;
import com.example.plusproject.domain.coupon.repository.CouponRepository;
import com.example.plusproject.domain.user.entity.User;
import com.example.plusproject.global.common.dto.AuthUser;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CouponService {

    private final CouponRepository couponRepository;
    private final CouponHistoryRepository couponHistoryRepository;

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public CouponIssueResponse CouponIssue(AuthUser authUser, Long couponId) {
        Coupon coupon = couponRepository.findById(couponId)
                .orElseThrow(() -> new CouponException(CouponExceptionCode.NOT_FOUND_COUPON));

        if (coupon.getQuantity() > 0 ){
            User user = User.fromAuthUser(authUser);
            coupon.decreaseQuantity();
            CouponHistory couponHistory = new CouponHistory(user, coupon);

            CouponHistory savedHistory = couponHistoryRepository.save(couponHistory);

            return CouponIssueResponse.builder()
                    .couponId(savedHistory.getId())
                    .couponId(coupon.getId())
                    .userId(user.getId())
                    .issuedAt(savedHistory.getIssued_at())
                    .build();
        }else{
            throw new CouponException(CouponExceptionCode.COUPON_OUT_OF_STOCK);
        }
    }
}
