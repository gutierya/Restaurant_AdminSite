package com.grubhub.lite.demo.exceptions.restaurant;

public class RestaurantNotAvailableException extends RuntimeException {
    RestaurantNotAvailableException(Long restaurantID) {
        super("Restaurant " + restaurantID + " is not available at this time");
    }
}
