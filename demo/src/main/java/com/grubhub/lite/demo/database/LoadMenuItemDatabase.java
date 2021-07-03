package com.grubhub.lite.demo.database;

import com.grubhub.lite.demo.repositories.DriverRepository;
import com.grubhub.lite.demo.repositories.MenuItemRepository;
import com.grubhub.lite.demo.services.MenuItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadMenuItemDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadMenuItemDatabase.class);

    @Bean
    CommandLineRunner initMenuItemDB(MenuItemRepository repository) {
        return args -> {
            log.info("Loading empty MenuItem Database");
        };
    }
}
