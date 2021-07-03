package com.grubhub.lite.demo.database;

import com.grubhub.lite.demo.models.Enums;
import com.grubhub.lite.demo.models.Restaurant;
import com.grubhub.lite.demo.repositories.DriverRepository;
import com.grubhub.lite.demo.repositories.RestaurantRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

@Configuration
public class LoadRestaurantDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDriverDatabase.class);

    private ArrayList<Enums.DietaryRestrictions> restrictions1 = new ArrayList<>();

    @Bean
    CommandLineRunner initRestaurantDB(RestaurantRepository repository) {
        restrictions1.add(Enums.DietaryRestrictions.DairyFree);
        return args -> {
            log.info("Preloading + " + repository.save(new Restaurant("Test", (short) 5, "0000 testing st", true,
                    new Date(2022,Calendar.DECEMBER,5), new Date(2023, Calendar.DECEMBER,5), Enums.Cuisine.American,
                    20.0, Enums.ValueProp.Cheap, new ArrayList<Long>(), restrictions1,
                    false, new ArrayList<String>())));
            restrictions1.clear();
            restrictions1.add(Enums.DietaryRestrictions.GlutenFree);
            log.info("Preloading + " + repository.save(new Restaurant("Test 2 ", (short) 2, "0000 testing st", false,
                    new Date(2022,Calendar.DECEMBER,5), new Date(2023, Calendar.DECEMBER,5), Enums.Cuisine.Chinese,
                    20.0, Enums.ValueProp.Cheap, new ArrayList<Long>(), restrictions1,
                    false, new ArrayList<String>())));
        };
    }
}
