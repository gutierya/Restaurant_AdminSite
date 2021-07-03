package com.grubhub.lite.demo.database;

import com.grubhub.lite.demo.models.Enums;
import com.grubhub.lite.demo.models.FoodOrder;
import com.grubhub.lite.demo.models.MenuItem;
import com.grubhub.lite.demo.repositories.DriverRepository;
import com.grubhub.lite.demo.repositories.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Configuration
public class LoadOrderDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadOrderDatabase.class);
    List<Long> menuItems = new ArrayList<>();


    @Bean
    CommandLineRunner initOrderDB(OrderRepository repository) {
        menuItems.add(1L);
        menuItems.add(50L);
        menuItems.add(23L);
        return args -> {
            log.info("Preloading " + repository.save(
                    new FoodOrder(new Date(2021, 07, 22), new Date(2021, 07, 22),
                            1L, menuItems, Enums.OrderStatus.Cooking, 1L, 2L,
                            50D, 7D, 30D, 2L, 13D, 1L)));
            menuItems.clear();
            menuItems.add(100L);
            menuItems.add(523L);
            menuItems.add(11455L);
            log.info("Preloading " + repository.save(
                    new FoodOrder(new Date(2021, 07, 22), new Date(2021, 07, 22),
                            1L, menuItems, Enums.OrderStatus.InTransit, 1L, 2L,
                            50D, 7D, 30D, 2L, 13D, 1L)));
            menuItems.clear();
            menuItems.add(141L);
            menuItems.add(51243L);
            menuItems.add(123551L);
            log.info("Preloading " + repository.save(
                    new FoodOrder(new Date(2021, 07, 22), new Date(2021, 07, 22),
                            1L, menuItems, Enums.OrderStatus.Delivered, 1L, 2L,
                            50D, 7D, 30D, 2L, 13D, 1L)));
            menuItems.clear();
            menuItems.add(123L);
            menuItems.add(5123778L);
            log.info("Preloading " + repository.save(
                    new FoodOrder(new Date(2021, 07, 22), new Date(2021, 07, 22),
                            1L, menuItems, Enums.OrderStatus.PaymentReceived, 1L, 2L,
                            50D, 7D, 30D, 2L, 13D, 1L)));

        };
    }
}
