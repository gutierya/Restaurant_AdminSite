package com.grubhub.lite.demo.database;

import com.grubhub.lite.demo.models.Enums;
import com.grubhub.lite.demo.models.FoodOrder;
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
    List<Long> menu = new ArrayList<>();


    @Bean
    CommandLineRunner initOrderDB(OrderRepository repository) {

        //American - orders
        menu.add(12L);
        menu.add(22L);
        menu.add(31L);
        menu.add(14L);
        menu.add(15L);
        menu.add(16L);
        menu.add(17L);
        return args -> {
            log.info("Preloading " + repository.save(
                    new FoodOrder(new Date(2021, 07, 22), new Date(2021, 07, 22),
                            1L, menu, Enums.OrderStatus.Cooking, 1L, 11L,
                            50D, 7D, 40D, 101L, 3D, 10L)));
            menu.clear();
            menu.add(13L);
            menu.add(21L);
            menu.add(30L);
            menu.add(13L);
            menu.add(14L);
            menu.add(15L);
            menu.add(18L);

            //Chinese - orders
            log.info("Preloading " + repository.save(
                    new FoodOrder(new Date(2021, 07, 22), new Date(2021, 07, 22),
                            2L, menu, Enums.OrderStatus.InTransit, 2L, 22L,
                            40D, 7D, 30D, 102L, 3D, 20L)));
            menu.clear();
            menu.add(13L);
            menu.add(21L);
            menu.add(30L);
            menu.add(13L);
            menu.add(14L);
            menu.add(15L);
            menu.add(18L);

            log.info("Preloading " + repository.save(
                    new FoodOrder(new Date(2021, 07, 22), new Date(2021, 07, 22),
                            2L, menu, Enums.OrderStatus.InTransit, 3L, 33L,
                            50D, 7D, 30D, 103L, 3D, 30L)));
            menu.clear();
            menu.add(13L);
            menu.add(21L);
            menu.add(30L);
            menu.add(13L);
            menu.add(14L);
            menu.add(15L);
            menu.add(18L);


            //Japanese - orders
            log.info("Preloading " + repository.save(
                    new FoodOrder(new Date(2021, 07, 23), new Date(2021, 07, 23),
                            3L, menu, Enums.OrderStatus.Delivered, 4L, 44L,
                            50D, 7D, 30D, 104L, 3D, 40L)));
            menu.clear();
            menu.add(13L);
            menu.add(21L);
            menu.add(30L);
            menu.add(13L);
            menu.add(14L);
            menu.add(15L);
            menu.add(18L);
            log.info("Preloading " + repository.save(
                    new FoodOrder(new Date(2021, 07, 23), new Date(2021, 07, 23),
                            3L, menu, Enums.OrderStatus.Delivered, 5L, 55L,
                            30D, 7D, 20D, 105L, 3D, 50L)));
            menu.clear();
            menu.add(13L);
            menu.add(21L);
            menu.add(30L);
            menu.add(13L);
            menu.add(14L);
            menu.add(15L);
            menu.add(18L);
            log.info("Preloading " + repository.save(
                    new FoodOrder(new Date(2021, 07, 23), new Date(2021, 07, 23),
                            4L, menu, Enums.OrderStatus.Delivered, 6L, 66L,
                            20D, 7D, 10D, 106L, 3D, 60L)));
            menu.clear();
            menu.add(13L);
            menu.add(21L);
            menu.add(30L);
            menu.add(13L);
            menu.add(14L);
            menu.add(15L);
            menu.add(18L);
            log.info("Preloading " + repository.save(
                    new FoodOrder(new Date(2021, 07, 23), new Date(2021, 07, 23),
                            4L, menu, Enums.OrderStatus.Delivered, 7L, 77L,
                            40D, 7D, 30D, 107L, 3D, 70L)));
            menu.clear();
            menu.add(13L);
            menu.add(21L);
            menu.add(30L);
            menu.add(13L);
            menu.add(14L);
            menu.add(15L);
            menu.add(18L);
            log.info("Preloading " + repository.save(
                    new FoodOrder(new Date(2021, 07, 24), new Date(2021, 07, 24),
                            5L, menu, Enums.OrderStatus.Cooking, 8L, 88L,
                            50D, 7D, 30D, 108L, 3D, 80L)));
            menu.clear();
            menu.add(13L);
            menu.add(21L);
            menu.add(30L);
            menu.add(13L);
            menu.add(14L);
            menu.add(15L);
            menu.add(18L);
            log.info("Preloading " + repository.save(
                    new FoodOrder(new Date(2021, 07, 24), new Date(2021, 07, 24),
                            5L, menu, Enums.OrderStatus.Cooking, 1L, 99L,
                            60D, 7D, 50D, 109L, 3D, 90L)));
            menu.clear();
            menu.add(13L);
            menu.add(21L);
            menu.add(30L);
            menu.add(13L);
            menu.add(14L);
            menu.add(15L);
            menu.add(18L);;
            log.info("Preloading " + repository.save(
                    new FoodOrder(new Date(2021, 07, 24), new Date(2021, 07, 24),
                            6L, menu, Enums.OrderStatus.AwaitingPickUp, 2L, 111L,
                            80D, 7D, 60D, 110L, 10D, 100L)));
            menu.clear();
            menu.add(13L);
            menu.add(21L);
            menu.add(30L);
            menu.add(13L);
            menu.add(14L);
            menu.add(15L);
            menu.add(18L);
            log.info("Preloading " + repository.save(
                    new FoodOrder(new Date(2021, 07, 24), new Date(2021, 07, 24),
                            6L, menu, Enums.OrderStatus.AwaitingPickUp, 3L, 122L,
                            60D, 7D, 30D, 111L, 3D, 110L)));
            menu.clear();
            menu.add(13L);
            menu.add(21L);
            menu.add(30L);
            menu.add(13L);
            menu.add(14L);
            menu.add(15L);
            menu.add(18L);
            log.info("Preloading " + repository.save(
                    new FoodOrder(new Date(2021, 07, 24), new Date(2021, 07, 24),
                            7L, menu, Enums.OrderStatus.Cancelled, 4L, 133L,
                            20D, 7D, 10D, 112L, 2D, 120L)));
            menu.clear();
            menu.add(13L);
            menu.add(21L);
            menu.add(30L);
            menu.add(13L);
            menu.add(14L);
            menu.add(15L);
            menu.add(18L);
            log.info("Preloading " + repository.save(
                    new FoodOrder(new Date(2021, 07, 24), new Date(2021, 07, 24),
                            7L, menu, Enums.OrderStatus.Cancelled, 5L, 144L,
                            40D, 7D, 30D, 113L, 4D, 130L)));
            menu.clear();

        };
    }
}
