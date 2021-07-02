package com.grubhub.lite.demo.Repo;

import com.grubhub.lite.demo.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepo extends JpaRepository<Payment, Long> {
}
