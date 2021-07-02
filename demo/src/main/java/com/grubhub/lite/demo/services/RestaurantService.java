package com.grubhub.lite.demo.services;

import com.grubhub.lite.demo.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {
    private RestaurantRepository restaurantRepository;

    @Autowired
    public void setPaymentRepository(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    // create
    // rate
    // update rating
    // search by value, take, diatary, open, type
}
