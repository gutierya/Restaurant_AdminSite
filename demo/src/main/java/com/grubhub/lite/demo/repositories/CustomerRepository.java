package com.grubhub.lite.demo.repositories;

import com.grubhub.lite.demo.models.Customer;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}

