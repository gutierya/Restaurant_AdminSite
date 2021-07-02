package com.grubhub.lite.demo.Repo;

import com.grubhub.lite.demo.models.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuItemRepo extends JpaRepository<MenuItem, Long> {

}
