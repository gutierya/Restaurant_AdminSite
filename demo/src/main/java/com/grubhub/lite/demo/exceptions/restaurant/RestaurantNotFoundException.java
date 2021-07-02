package com.grubhub.lite.demo.exceptions.restaurant;

public class RestaurantNotFoundException extends RuntimeException{
    RestaurantNotFoundException(Long restaurantID) {
        super("Restaurant " + restaurantID + " not found");
    }
}
