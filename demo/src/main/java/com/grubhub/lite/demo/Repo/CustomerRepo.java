package com.grubhub.lite.demo.Repo;

import com.grubhub.lite.demo.models.Customer;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {

}

