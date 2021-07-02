package com.grubhub.lite.demo.exceptions.restaurant;

public class RestaurantNotAvailableException extends RuntimeException {
    public RestaurantNotAvailableException(Long restaurantID) {
        super("Restaurant " + restaurantID + " is not available at this time");
    }
}
