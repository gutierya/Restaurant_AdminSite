package com.grubhub.lite.demo.Repo;

import com.grubhub.lite.demo.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order, Long> {
}
