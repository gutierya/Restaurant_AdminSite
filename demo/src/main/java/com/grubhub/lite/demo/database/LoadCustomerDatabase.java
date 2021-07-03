package com.grubhub.lite.demo.database;

import com.grubhub.lite.demo.repositories.CustomerRepository;
import com.grubhub.lite.demo.services.DriverService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadCustomerDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadCustomerDatabase.class);

    @Bean
    CommandLineRunner initCustomerDB(CustomerRepository repository) {
        return args -> {
            log.info("Loading empty Customer Database");
        };
    }
}
