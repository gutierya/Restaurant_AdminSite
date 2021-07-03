package com.grubhub.lite.demo.controllers;

import com.grubhub.lite.demo.models.Enums;
import com.grubhub.lite.demo.models.Restaurant;
import com.grubhub.lite.demo.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
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
    @RequestMapping(value = "/restaurants", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Restaurant> getAllRestaurant() {
        return getAllRestaurant();
    }

    /**
     * get restaurants if - open
     * @return
     */
    @RequestMapping(value = "/restaurant", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Boolean getRestaurantIfOpen(@RequestParam(value = "isOpen") Long isOpen) {
        return restaurantService.getIsOpen(isOpen);
    }

    /**
     * get restaurants by cuisine
     */
    @RequestMapping(value = "/restaurant", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Enums.Cuisine getRestaurantByCuisine(@RequestParam(value = "orderId")  Long orderId) {
        return this.restaurantService.getType(orderId);
    }

    /**
     * get restaurants by value proposition
     */
    @RequestMapping(value = "/restaurant", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Enums.ValueProp getRestaurantByValueProp(@RequestParam(value = "orderId")  Long orderId) {
        return this.restaurantService.getValueProposition(orderId);
    }

    /**
     * get restaurants by rating
     */
    @RequestMapping(value = "/restaurant", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Short getRestaurantByRating(@RequestParam(value = "id") Long id) {
        return this.restaurantService.getRating(id);
    }


    //Singular view
    /**
     * get restaurant - by restaurant id
     */
    @RequestMapping(value = "/restaurant", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Restaurant getRestaurantByID(@RequestParam(value = "id") Long id) {
        return restaurantService.getRestaurantByid(id);
    }

    /**
     * Get restaurant takeout offers
     * @return
     */
    @RequestMapping(value = "/restaurant/{restaurantID}/items", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Boolean getAllItems(@PathVariable(value = "id") Long id) {
        return this.restaurantService.getOffersTakeout(id);
    }
}
