package com.grubhub.lite.demo.controllers;

import com.grubhub.lite.demo.models.Enums;
import com.grubhub.lite.demo.models.Restaurant;
import com.grubhub.lite.demo.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    private RestaurantService restaurantService; //

    @Autowired
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    //empty constructor
    public RestaurantController() { }

    //aggregate view
    /**
     * Get all restaurants
     */
    @GetMapping(value = "/")
    public List<Restaurant> getAllRestaurant() {
        return restaurantService.getRestaurants();
    }

    /**
     * get restaurants if - open
     * @return
     */
    @GetMapping(value = "/open")
    public List<Restaurant> getRestaurantIfOpen() {
        return restaurantService.getByIsOpen();
    }

    /**
     * get restaurants by cuisine
     */
//    @RequestMapping(value = "/restaurant", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseBody
    @GetMapping("/cuisine/{cuisine}")
    public List<Restaurant> getRestaurantByCuisine(@PathVariable Enums.Cuisine cuisine) {
        return this.restaurantService.getByType(cuisine);
    }

    /**
     * get restaurants by value proposition
     */
//    @RequestMapping(value = "/restaurant", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseBody
    @GetMapping("/valueProp/{valueProp}")
    public List<Restaurant> getRestaurantByValueProp(@PathVariable Enums.ValueProp valueProp) {
        return this.restaurantService.getByValueProposition(valueProp);
    }

    /**
     * get restaurants by rating
     */
    @GetMapping(value = "/rating/{rating}")
    public List<Restaurant> getRestaurantByRating(@PathVariable Short rating) {
        return this.restaurantService.getRating(rating);
    }


    //Singular view
    /**
     * get restaurant - by restaurant id
     */
    @GetMapping(value = "/byID/{id}")
    public Restaurant getRestaurantByID(@PathVariable Long id) {
        return restaurantService.getRestaurantByid(id);
    }

    /**
     * Get restaurant takeout offers
     * @return
     */
    @RequestMapping(value = "/{restaurantID}/items", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Boolean getAllItems(@PathVariable Long restaurantID) {
        return this.restaurantService.getOffersTakeout(restaurantID);
    }

    @GetMapping("/byDietaryRestrictions")
    public List<Restaurant> getByDietaryRestrictions(@RequestBody List<Enums.DietaryRestrictions> restrictions) {
        return restaurantService.getByRestrictions(restrictions);
    }
}
