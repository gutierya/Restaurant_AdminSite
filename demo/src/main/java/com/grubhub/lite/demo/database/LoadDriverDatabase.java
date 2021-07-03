package com.grubhub.lite.demo.database;

import com.grubhub.lite.demo.models.Driver;
import com.grubhub.lite.demo.models.Enums;
import com.grubhub.lite.demo.repositories.DriverRepository;
import com.grubhub.lite.demo.services.DriverService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Configuration
public class LoadDriverDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDriverDatabase.class);

    List<Driver> drivers = new ArrayList<>();

    @Bean
    CommandLineRunner initDriverDB(DriverRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new Driver((short) 3, Enums.VehicleType.Scooter,new Date(2021, 7, 1),"1A")) );

            log.info("Preloading " + repository.save(new Driver((short) 4, Enums.VehicleType.Bicycle,new Date(2021, 7, 2),"1B")) );
        };
    }
}


