package com.grubhub.lite.demo.database;

import com.grubhub.lite.demo.models.Restaurant;
import com.grubhub.lite.demo.repositories.DriverRepository;
import com.grubhub.lite.demo.repositories.RestaurantRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadRestaurantDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDriverDatabase.class);

    @Bean
    CommandLineRunner initRestaurantDB(RestaurantRepository repository) {
        return args -> {
            log.info("Loading empty " + this.getClass().getName());
        };
    }
}
