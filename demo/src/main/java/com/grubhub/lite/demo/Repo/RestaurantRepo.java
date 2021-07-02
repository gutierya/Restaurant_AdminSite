package com.grubhub.lite.demo.Repo;

import com.grubhub.lite.demo.models.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepo extends JpaRepository<Restaurant, Long> {

}
