package com.grubhub.lite.demo.exceptions.restaurant;

public class RestaurantAlreadyExistsException extends RuntimeException {
    RestaurantAlreadyExistsException(Long restaurantID) {
        super("Restaurant " + restaurantID + " already Exits");
    }
}
