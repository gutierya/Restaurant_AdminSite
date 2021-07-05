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
    List<String> menuItems = new ArrayList<>();


    @Bean
    CommandLineRunner initOrderDB(OrderRepository repository) {

        //American - orders
        menuItems.add("Burger");
        menuItems.add("Chili Cheese Fries");
        menuItems.add("ice cream");
        return args -> {
            log.info("Preloading " + repository.save(
                    new FoodOrder(new Date(2021, 07, 22), new Date(2021, 07, 22),
                            1L, menuItems, Enums.OrderStatus.Cooking, 1L, 11L,
                            50D, 7D, 40D, 101L, 3D, 10L)));
            menuItems.clear();

            //Chinese - orders
            menuItems.add("Dim Sum");
            log.info("Preloading " + repository.save(
                    new FoodOrder(new Date(2021, 07, 22), new Date(2021, 07, 22),
                            2L, menuItems, Enums.OrderStatus.InTransit, 2L, 22L,
                            40D, 7D, 30D, 102L, 3D, 20L)));
            menuItems.clear();

            menuItems.add("Ginger scallion lobster");
            log.info("Preloading " + repository.save(
                    new FoodOrder(new Date(2021, 07, 22), new Date(2021, 07, 22),
                            2L, menuItems, Enums.OrderStatus.InTransit, 3L, 33L,
                            50D, 7D, 30D, 103L, 3D, 30L)));
            menuItems.clear();


            //Japanese - orders
            menuItems.add("Sushi");
            log.info("Preloading " + repository.save(
                    new FoodOrder(new Date(2021, 07, 23), new Date(2021, 07, 23),
                            3L, menuItems, Enums.OrderStatus.Delivered, 4L, 44L,
                            50D, 7D, 30D, 104L, 3D, 40L)));
            menuItems.clear();

            menuItems.add("Tako Poke Bowl");
            menuItems.add("Dumplings");
            log.info("Preloading " + repository.save(
                    new FoodOrder(new Date(2021, 07, 23), new Date(2021, 07, 23),
                            3L, menuItems, Enums.OrderStatus.Delivered, 5L, 55L,
                            30D, 7D, 20D, 105L, 3D, 50L)));
            menuItems.clear();

            //Korean - orders
            menuItems.add("Seoul chicken");
            log.info("Preloading " + repository.save(
                    new FoodOrder(new Date(2021, 07, 23), new Date(2021, 07, 23),
                            4L, menuItems, Enums.OrderStatus.Delivered, 6L, 66L,
                            20D, 7D, 10D, 106L, 3D, 60L)));
            menuItems.clear();

            menuItems.add("Ramen");
            menuItems.add("Beef Bulgogi");
            log.info("Preloading " + repository.save(
                    new FoodOrder(new Date(2021, 07, 23), new Date(2021, 07, 23),
                            4L, menuItems, Enums.OrderStatus.Delivered, 7L, 77L,
                            40D, 7D, 30D, 107L, 3D, 70L)));
            menuItems.clear();


            //Latin - orders
            menuItems.add("Burrito carnitas");
            log.info("Preloading " + repository.save(
                    new FoodOrder(new Date(2021, 07, 24), new Date(2021, 07, 24),
                            5L, menuItems, Enums.OrderStatus.Cooking, 8L, 88L,
                            50D, 7D, 30D, 108L, 3D, 80L)));
            menuItems.clear();

            menuItems.add("Fish tacos");
            menuItems.add("Steak plate");
            log.info("Preloading " + repository.save(
                    new FoodOrder(new Date(2021, 07, 24), new Date(2021, 07, 24),
                            5L, menuItems, Enums.OrderStatus.Cooking, 1L, 99L,
                            60D, 7D, 50D, 109L, 3D, 90L)));
            menuItems.clear();

            //Hispanic - orders
            menuItems.add("Peruvian Ceviche");
            menuItems.add("Argentine Steak");
            log.info("Preloading " + repository.save(
                    new FoodOrder(new Date(2021, 07, 24), new Date(2021, 07, 24),
                            6L, menuItems, Enums.OrderStatus.AwaitingPickUp, 2L, 111L,
                            80D, 7D, 60D, 110L, 10D, 100L)));
            menuItems.clear();

            menuItems.add("Columbian arepas");
            log.info("Preloading " + repository.save(
                    new FoodOrder(new Date(2021, 07, 24), new Date(2021, 07, 24),
                            6L, menuItems, Enums.OrderStatus.AwaitingPickUp, 3L, 122L,
                            60D, 7D, 30D, 111L, 3D, 110L)));
            menuItems.clear();

            //Fast food - orders
            menuItems.add("Buffalo Wings");
            log.info("Preloading " + repository.save(
                    new FoodOrder(new Date(2021, 07, 24), new Date(2021, 07, 24),
                            7L, menuItems, Enums.OrderStatus.Cancelled, 4L, 133L,
                            20D, 7D, 10D, 112L, 2D, 120L)));
            menuItems.clear();

            menuItems.add("hot Dog");
            menuItems.add("Caesar salad");
            log.info("Preloading " + repository.save(
                    new FoodOrder(new Date(2021, 07, 24), new Date(2021, 07, 24),
                            7L, menuItems, Enums.OrderStatus.Cancelled, 5L, 144L,
                            40D, 7D, 30D, 113L, 4D, 130L)));
            menuItems.clear();

        };
    }
}
