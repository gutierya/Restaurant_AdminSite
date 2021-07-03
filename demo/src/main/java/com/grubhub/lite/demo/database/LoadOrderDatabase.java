package com.grubhub.lite.demo.database;

import com.grubhub.lite.demo.repositories.DriverRepository;
import com.grubhub.lite.demo.repositories.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadOrderDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadOrderDatabase.class);

    @Bean
    CommandLineRunner initOrderDB(OrderRepository repository) {
        return args -> {
            log.info("Loading empty " + this.getClass().getName());
        };
    }
}
