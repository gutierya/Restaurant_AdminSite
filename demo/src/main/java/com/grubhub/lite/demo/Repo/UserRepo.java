package com.grubhub.lite.demo.Repo;

import com.grubhub.lite.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
