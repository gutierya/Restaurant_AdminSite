package com.grubhub.lite.demo.database;

import com.grubhub.lite.demo.models.Customer;
import com.grubhub.lite.demo.models.FoodOrder;
import com.grubhub.lite.demo.models.Restaurant;
import com.grubhub.lite.demo.repositories.CustomerRepository;
import com.grubhub.lite.demo.services.DriverService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class LoadCustomerDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadCustomerDatabase.class);

    List<Customer> customerList = new ArrayList<>();
    List<Long> favRestaurants = new ArrayList<>();
    List<Long> orderHistory = new ArrayList<>();
    List<Long> favItems = new ArrayList<>();

    @Bean
    CommandLineRunner initCustomerDB(CustomerRepository repository) {
        favRestaurants.add(1L);
        favRestaurants.add(2L);
        favRestaurants.add(3L);

        orderHistory.add(4L);
        orderHistory.add(5L);
        orderHistory.add(6L);

        favItems.add(7L);
        favItems.add(8L);

        return args -> {
            log.info("Preloading " + repository.save(new Customer("1S", "123 main st", orderHistory, favRestaurants,favItems)));
            favRestaurants.clear();
            orderHistory.clear();
            favItems.clear();

            favRestaurants.add(9L);
            favRestaurants.add(10L);

            orderHistory.add(11L);
            orderHistory.add(12L);

            favItems.add(13L);
            favItems.add(14L);

            log.info("Preloading " + repository.save(new Customer("1T", "456 water st", orderHistory, favRestaurants,favItems)));
        };
    }
}

