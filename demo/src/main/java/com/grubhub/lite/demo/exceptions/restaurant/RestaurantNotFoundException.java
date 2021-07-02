package com.grubhub.lite.demo.exceptions.restaurant;

public class RestaurantNotFoundException extends RuntimeException{
    public RestaurantNotFoundException(Long restaurantID) {
        super("Restaurant " + restaurantID + " not found");
    }
}
