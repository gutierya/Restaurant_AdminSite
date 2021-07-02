package com.grubhub.lite.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grubhub.lite.demo.models.Driver;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {

}
