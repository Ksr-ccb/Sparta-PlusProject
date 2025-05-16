package com.example.plusproject.domain.coupon.repository;

import com.example.plusproject.domain.coupon.entity.CouponHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponHistoryRepository extends JpaRepository<CouponHistory, Long> {
}
