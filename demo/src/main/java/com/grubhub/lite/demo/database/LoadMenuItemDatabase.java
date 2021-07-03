package com.grubhub.lite.demo.database;

import com.grubhub.lite.demo.models.Driver;
import com.grubhub.lite.demo.models.Enums;
import com.grubhub.lite.demo.models.MenuItem;
import com.grubhub.lite.demo.repositories.DriverRepository;
import com.grubhub.lite.demo.repositories.MenuItemRepository;
import com.grubhub.lite.demo.services.MenuItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class LoadMenuItemDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadMenuItemDatabase.class);

    List<MenuItem> menuItems = new ArrayList<>();
    List<String> ingredients = new ArrayList<>();

    @Bean
    CommandLineRunner initMenuItemDB(MenuItemRepository repository) {
        ingredients.add("beef patty");
        ingredients.add("GF bread");
        ingredients.add("lettuce");
        ingredients.add("cheese slice");
        ingredients.add("tomato");
        return args -> {
            log.info("Preloading " + repository.save(new MenuItem("Burger", "cheesy cheese burger", ingredients,1000,true,"https://images.unsplash.com/photo-1605789538467-f715d58e03f9?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1502&q=80",20D, Enums.DietaryRestrictions.GlutenFree,"Lunch", 5L)));

//            ingredients.clear();

            ingredients.add("chocolate chips");
            ingredients.add("syrup");
            ingredients.add("sprinkles");

            log.info("Preloading " + repository.save(new MenuItem("ice cream","mint choc chip ice cream", ingredients,200,true,"https://images.unsplash.com/photo-1558586538-5d88218be34c?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=3024&q=80",10D, Enums.DietaryRestrictions.DairyFree,"Dessert", 6L)));
        };
    }
}



//    public MenuItem(String itemName, String description, List<String> ingredients, Integer calories, Boolean isInStock,
//                    String imageUrl, Double price, List<Enums.DietaryRestrictions> dietaryRestrictions, String category,
//                    Long restaurantID) {