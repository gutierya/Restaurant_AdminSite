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

        //American restaurant - menu items
        ingredients.add("beef patty");
        ingredients.add("GF bread");
        ingredients.add("lettuce");
        ingredients.add("cheese slice");
        ingredients.add("tomato");
        return args -> {
            log.info("Preloading " + repository.save(new MenuItem("Burger", "Cheesy cheese cheesiest burger.", ingredients,1000,true,"https://images.unsplash.com/photo-1605789538467-f715d58e03f9?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1502&q=80",20D, Enums.DietaryRestrictions.GlutenFree,"Lunch", 1L)));
//            ingredients.clear();
            ingredients.add("chocolate chips");
            ingredients.add("syrup");
            ingredients.add("sprinkles");

            log.info("Preloading " + repository.save(new MenuItem("ice cream","Mint choc chip ice cream.", ingredients,200,true,"https://images.unsplash.com/photo-1558586538-5d88218be34c?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=3024&q=80",10D, Enums.DietaryRestrictions.DairyFree,"Dessert", 1L)));

            ingredients.add("homemade french fries");
            ingredients.add("special hot sauce");
            ingredients.add("five spicy cheese blend");

            log.info("Preloading " + repository.save(new MenuItem("Chili Cheese Fries","Our traditional french fries topped with chili and cheddar Jack cheese.", ingredients,200,true,"https://images.unsplash.com/photo-1564115895589-c8c6bd1076f8?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1650&q=80",10D, Enums.DietaryRestrictions.Vegetarian,"Lunch", 1L)));

            ingredients.add("Bacon");
            ingredients.add("Mac and Cheese");
            ingredients.add("Dipping Sauce");

            log.info("Preloading " + repository.save(new MenuItem("Mac and Cheese","Mac and cheese in a fried bite-sized snack.", ingredients,300,true,"https://images.unsplash.com/photo-1612892010343-983bfd063dc5?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1000&q=80",15D, Enums.DietaryRestrictions.NA,"Lunch", 1L)));

            ingredients.add("chicken");
            ingredients.add("cajun spices");
            ingredients.add("dipping sauce selection");

            log.info("Preloading " + repository.save(new MenuItem("ice cream","Hand-breaded tenders accompanied by your choice of dipping sauce.", ingredients,200,true,"https://images.unsplash.com/photo-1605291581926-df4bf7ee3e89?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1650&q=80",10D, Enums.DietaryRestrictions.NA,"Dessert", 1L)));


            //Chinese Restaurant - menu items
            ingredients.add("Dim sum");
            ingredients.add("Soy Sauce");
            ingredients.add("Dessert sum");

            log.info("Preloading " + repository.save(new MenuItem("Dim sum ", "Chinese dish of small steamed or fried savory dumplings containing various fillings, served as a snack or main course.", ingredients,400,true,"https://images.unsplash.com/photo-1607857530521-53448b220fe8?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1650&q=80",40D, Enums.DietaryRestrictions.NA,"Brunch", 2L)));

            ingredients.add("noodles");
            ingredients.add("scallions");
            ingredients.add("lobster");

            log.info("Preloading " + repository.save(new MenuItem("Ginger scallion lobster","Mint choc chip ice cream.", ingredients,500,true,"https://images.unsplash.com/photo-1588791174744-7e9bf4378277?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1650&q=80",100D, Enums.DietaryRestrictions.NA,"Dinner", 2L)));

            ingredients.add("tofu");
            ingredients.add("white rice");
            ingredients.add("veggies");

            log.info("Preloading " + repository.save(new MenuItem("Vegetable rice plate","Our traditional veggie vegan plate.", ingredients,300,true,"https://images.unsplash.com/photo-1512003867696-6d5ce6835040?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1650&q=80",10D, Enums.DietaryRestrictions.Vegan,"Lunch", 2L)));

            ingredients.add("chicken");
            ingredients.add("white rice");
            ingredients.add("veggies");

            log.info("Preloading " + repository.save(new MenuItem("orange chicken rice plate","Our traditional chicken veggie plate.", ingredients,300,true,"https://images.unsplash.com/photo-1623689046286-01d812cc8bad?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1654&q=80",10D, Enums.DietaryRestrictions.NA,"Lunch", 2L)));

            //Japanese
            ingredients.add("fish");
            ingredients.add("rice");
            ingredients.add("seaweed");

            log.info("Preloading " + repository.save(new MenuItem("Sushi ", "dish consisting of small balls or rolls of vinegar-flavored cold cooked rice served with a garnish of raw fish, vegetables, or egg.", ingredients,200,true,"https://images.unsplash.com/photo-1611143669185-af224c5e3252?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=2090&q=80",40D, Enums.DietaryRestrictions.NA,"All day", 3L)));

            ingredients.add("toppings");
            ingredients.add("rice");
            ingredients.add("raw fish");

            log.info("Preloading " + repository.save(new MenuItem("Tako Poke Bowl","diced raw fish served either as an appetizer or a main course.", ingredients,300,true,"https://images.unsplash.com/photo-1561954468-039c5f32644d?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=668&q=80",20D, Enums.DietaryRestrictions.NA,"All day", 3L)));

            ingredients.add("dumpling veggie fillings");
            ingredients.add("soy sauce");

            log.info("Preloading " + repository.save(new MenuItem("Dumplings","Our traditional veggie vegan plate.", ingredients,300,true,"https://images.unsplash.com/photo-1523905330026-b8bd1f5f320e?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1658&q=80",10D, Enums.DietaryRestrictions.Vegan,"Lunch", 3L)));

            ingredients.add("rice");
            ingredients.add("water sugar");
            ingredients.add("cornstarch");

            log.info("Preloading " + repository.save(new MenuItem("mochi ice cream","Japanese rice cake.", ingredients,50,true,"https://images.unsplash.com/photo-1604498149220-bfb7c7cfd19b?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1650&q=80",10D, Enums.DietaryRestrictions.NA,"Dessert", 3L)));

            //Korean
            ingredients.add("beef");
            ingredients.add("rice");
            ingredients.add("vegetables");

            log.info("Preloading " + repository.save(new MenuItem("Beef Bulgogi ", "fire meat, is a gui made of thin, marinated slices of beef or pork grilled on a barbecue or on a stove-top griddle.", ingredients,500,true,"https://images.unsplash.com/photo-1584278858536-52532423b9ea?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1650&q=80",40D, Enums.DietaryRestrictions.NA,"All day", 4L)));

            ingredients.add("toppings");
            ingredients.add("rice");
            ingredients.add("chicken");

            log.info("Preloading " + repository.save(new MenuItem("Seoul chicken","Korean traditional fried chicken wings.", ingredients,400,true,"https://images.unsplash.com/photo-1557038684-abb03178899e?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1100&q=80",20D, Enums.DietaryRestrictions.NA,"All day", 4L)));

            ingredients.add("broth");
            ingredients.add("noodles");

            log.info("Preloading " + repository.save(new MenuItem("Ramen","wheat noodles served in a meat or fish-based broth.", ingredients,100,true,"https://images.unsplash.com/photo-1557872943-16a5ac26437e?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1616&q=80",20D, Enums.DietaryRestrictions.NA,"Lunch", 4L)));

            ingredients.add("rice");
            ingredients.add("chicken");
            ingredients.add("vegtables");

            log.info("Preloading " + repository.save(new MenuItem("Bibmbap","Served with rice and a side dish.", ingredients,50,true,"https://images.unsplash.com/photo-1553163147-622ab57be1c7?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1650&q=80",10D, Enums.DietaryRestrictions.NA,"Lunch", 4L)));

            //Latin
            ingredients.add("beef");
            ingredients.add("tortilla");
            ingredients.add("vegetables");

            log.info("Preloading " + repository.save(new MenuItem("Burrito carnitas ", "Burritos with complementary chips and salsa.", ingredients,500,true,"https://images.unsplash.com/photo-1562059390-a761a084768e?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1606&q=80",40D, Enums.DietaryRestrictions.NA,"All day", 5L)));

            ingredients.add("toppings");
            ingredients.add("steak");
            ingredients.add("rice");

            log.info("Preloading " + repository.save(new MenuItem("Steak plate","Grilled Steak, with Rice, beans and salad.", ingredients,400,true,"https://images.unsplash.com/photo-1598514983195-94d7470a4241?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1650&q=80",20D, Enums.DietaryRestrictions.NA,"All day", 5L)));

            ingredients.add("Fish mix");
            ingredients.add("tortilla");
            ingredients.add("vegetables");

            log.info("Preloading " + repository.save(new MenuItem("Fish Tacos","Tacos with fish vs meat.", ingredients,300,true,"https://images.unsplash.com/photo-1565299585323-38d6b0865b47?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1014&q=80",20D, Enums.DietaryRestrictions.NA,"Lunch", 5L)));

            ingredients.add("corn");
            ingredients.add("cheese");
            ingredients.add("chipotle sauce");

            log.info("Preloading " + repository.save(new MenuItem("Elote corn","Grilled Corn, with parmesan Cheese, Chiplote Sauce.", ingredients,50,true,"https://images.unsplash.com/photo-1619221881992-78381378c20c?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=668&q=80",10D, Enums.DietaryRestrictions.Vegetarian,"Lunch", 5L)));

            //Hispanic
            ingredients.add("shrimp");
            ingredients.add("lime");
            ingredients.add("ceviche mix");

            log.info("Preloading " + repository.save(new MenuItem("Peruvian Ceviche ", "Citrus shrimp ceviche.", ingredients,200,true,"https://images.unsplash.com/photo-1619221881833-5e5aeff458fd?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=668&q=80",20D, Enums.DietaryRestrictions.NA,"All day", 6L)));

            ingredients.add("toppings");
            ingredients.add("steak");
            ingredients.add("rice");

            log.info("Preloading " + repository.save(new MenuItem("Argentine steak ","Grilled Steak, with Rice, beans and salad.", ingredients,400,true,"https://images.unsplash.com/photo-1542365887-1149961dccc7?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1650&q=80",30D, Enums.DietaryRestrictions.NA,"All day", 6L)));

            ingredients.add("Flour");
            ingredients.add("meat filling");
            ingredients.add("vegetables");

            log.info("Preloading " + repository.save(new MenuItem("Columbian arepas","Wholesome fried jumbo arepas.", ingredients,500,true,"https://images.unsplash.com/photo-1619683909216-820c3bc64b67?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1655&q=80",20D, Enums.DietaryRestrictions.NA,"Lunch", 6L)));

            ingredients.add("Meat");
            ingredients.add("plantain leaves");
            ingredients.add("fillings");

            log.info("Preloading " + repository.save(new MenuItem("Venezuelan tamales","Hallacas meat tamales.", ingredients,50,true,"https://images.unsplash.com/photo-1552332386-1634d96809cf?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1650&q=80",10D, Enums.DietaryRestrictions.Vegetarian,"Lunch", 6L)));

            //Fast food
            ingredients.add("bun");
            ingredients.add("hot dog");
            ingredients.add("toppings");

            log.info("Preloading " + repository.save(new MenuItem("Hot dog ", "Best hotdog.", ingredients,100,true,"https://images.unsplash.com/photo-1541151040323-4d766525ec84?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=668&q=80",10D, Enums.DietaryRestrictions.NA,"All day", 7L)));

            ingredients.add("romaine lettuce");
            ingredients.add("cheese");
            ingredients.add("croutons");

            log.info("Preloading " + repository.save(new MenuItem("Caesar salad ","Healthy quick on the go salad.", ingredients,200,true,"https://images.unsplash.com/photo-1546793665-c74683f339c1?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=668&q=80",10D, Enums.DietaryRestrictions.NA,"All day", 7L)));

            ingredients.add("wings");
            ingredients.add("blue cheese sauce");
            ingredients.add("french fries");

            log.info("Preloading " + repository.save(new MenuItem("Buffalo wings","Mild, spicy wings with sauce.", ingredients,500,true,"https://images.unsplash.com/photo-1608039755401-742074f0548d?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=975&q=80",20D, Enums.DietaryRestrictions.NA,"Lunch", 7L)));

            ingredients.add("patty");
            ingredients.add("bread");
            ingredients.add("fillings");

            log.info("Preloading " + repository.save(new MenuItem("Burger","Fast cheesy burger.", ingredients,50,true,"https://images.unsplash.com/photo-1568901346375-23c9450c58cd?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1502&q=80",15D, Enums.DietaryRestrictions.Vegetarian,"Lunch", 7L)));

        };
    }
}

